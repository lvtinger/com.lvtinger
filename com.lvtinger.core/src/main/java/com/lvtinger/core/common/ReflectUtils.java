package com.lvtinger.core.common;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 反射工具类
 *
 * @author qiuxu
 */
public final class ReflectUtils {

    /**
     * 扫描类
     * @param classes 类存储集合
     * @param packageName 扫描的程序集
     */
    public static void scanType(final Set<Class<?>> classes, final String packageName) {
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

    private static void scanJar(final Set<Class<?>> classes, final URL url, final String packageName) {
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

    private static void scanFile(final Set<Class<?>> classes, final File file, String packageName) {
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