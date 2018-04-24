package com.lvtinger.core.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * 反射工具类
 *
 * @author qiuxu
 */
public final class ReflectUtils {

    private final static Map<Class<?>, Field[]> declareFieldCached = new ConcurrentHashMap<>(256);
    private final static Map<Class<?>, Method[]> declareMethodCached = new ConcurrentHashMap<>(256);
    private final static Map<Class<?>, Constructor<?>[]> declareConstructorCached = new ConcurrentHashMap<>(256);
    private final static Field[] NO_FIELD = {};
    private final static Method[] NO_METHOD = {};
    private final static Constructor<?>[] NO_CONSTRUCTOR = {};

    public static Constructor<?>[] getDeclareConstructor(Class<?> clazz){
        if(clazz == null || clazz.isInterface() || clazz.isEnum() || clazz.isAnnotation()){
            return NO_CONSTRUCTOR;
        }
        Constructor<?>[] constructors = declareConstructorCached.get(clazz);
        if(constructors == null){
            constructors = clazz.getConstructors();
            declareConstructorCached.put(clazz, constructors.length == 0 ? NO_CONSTRUCTOR:constructors);
        }

        return constructors;
    }

    public static Method[] getDeclareMethod(Class<?> clazz) {
        if (clazz == null) {
            return NO_METHOD;
        }

        Method[] methods = declareMethodCached.get(clazz);
        if (methods == null) {
            methods = clazz.getDeclaredMethods();
            declareMethodCached.put(clazz, methods.length == 0 ? NO_METHOD : methods);
        }

        return methods;
    }

    /**
     * 获取类中的字段
     *
     * @param clazz 类
     * @return 字段数组，如果类中没有字段返回{}
     */
    public static Field[] getDeclareField(Class<?> clazz) {
        if (clazz == null) {
            return NO_FIELD;
        }
        Field[] fields = declareFieldCached.get(clazz);
        if (fields == null) {
            fields = clazz.getDeclaredFields();
            declareFieldCached.put(clazz, fields.length == 0 ? NO_FIELD : fields);
        }
        return fields;
    }

    /**
     * 扫描对象
     *
     * @param packageName 扫描的包名
     * @return 扫描到的类型集合
     */
    public static Collection<Class<?>> scanType(final String packageName) {
        Collection<Class<?>> classes = new LinkedList<>();
        scanType(classes, packageName);
        return classes;
    }

    /**
     * 扫描并筛选对象
     *
     * @param packageName 扫描的包名
     * @param predicate   赛选条件
     * @return 扫描并筛选的类型集合
     */
    public static Collection<Class<?>> scanType(final String packageName, Predicate<Class<?>> predicate) {
        Collection<Class<?>> classes = new LinkedList<>();
        scanType(classes, packageName);
        return classes.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * 扫描包中的类型
     *
     * @param packages 要扫描的包
     * @return 扫描到的对象
     */
    public static Collection<Class<?>> scanType(final Collection<String> packages) {
        Collection<Class<?>> classes = new LinkedList<>();
        packages.forEach(packageName -> scanType(classes, packageName));
        return classes;
    }

    /**
     * 扫描包中的类型，并做筛选
     *
     * @param packages  需要扫描的类型
     * @param predicate 筛选条件
     * @return 扫描筛选结果
     */
    public static Collection<Class<?>> scanType(final Collection<String> packages, Predicate<Class<?>> predicate) {
        if (CollectionUtils.isEmpty(packages)) {
            return Collections.emptyList();
        }

        Collection<Class<?>> classes = scanType(packages);
        if (CollectionUtils.isEmpty(classes)) {
            return Collections.emptyList();
        }

        return predicate == null ? classes : classes.stream().filter(predicate).collect(Collectors.toSet());
    }

    /**
     * 扫描类
     *
     * @param classes     类存储集合
     * @param packageName 扫描的程序集
     */
    private static void scanType(final Collection<Class<?>> classes, final String packageName) {
        if (classes == null || StringUtils.isEmpty(packageName)) {
            return;
        }

        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName.replaceAll("\\.", "/"));

            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url == null) {
                    continue;
                }

                String protocol = url.getProtocol();

                if ("file".equals(protocol)) {
                    scanFile(classes, new File(url.getFile()), packageName);
                } else if ("jar".equals(protocol)) {
                    scanJar(classes, url, packageName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void scanJar(final Collection<Class<?>> classes, final URL url, final String packageName) {
        JarFile jarFile = null;
        try {
            JarURLConnection connection = (JarURLConnection) url.openConnection();
            if (connection == null) {
                return;
            }
            jarFile = connection.getJarFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (jarFile == null) {
            return;
        }

        String prefix = packageName.replaceAll("\\.", "/") + "/";
        Enumeration<JarEntry> jarEntries = jarFile.entries();
        while (jarEntries.hasMoreElements()) {
            JarEntry entry = jarEntries.nextElement();
            String entryName = entry.getName();
            if (entryName.endsWith(".class") && entryName.startsWith(prefix)) {
                String className = entryName.substring(0, entryName.length() - 6);
                className = className.replaceAll("/", "\\.");
                try {
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void scanFile(final Collection<Class<?>> classes, final File file, String packageName) {
        File[] files = file.listFiles();
        if (ArrayUtils.isEmpty(files)) {
            return;
        }

        for (File f : files) {
            if (f.isDirectory()) {
                scanFile(classes, f, packageName + f.getName());
                continue;
            }
            String fileName = f.getName();
            if (fileName.endsWith(".class")) {
                String className =
                        fileName.replaceAll("/", "\\.")
                                .substring(0, fileName.length() - 6);
                try {
                    classes.add(Class.forName(packageName + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}