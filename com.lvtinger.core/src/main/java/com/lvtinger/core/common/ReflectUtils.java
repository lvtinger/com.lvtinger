package com.lvtinger.core.common;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

/**
 * 反射工具类
 *
 * @author qiuxu
 */
public final class ReflectUtils {

    public static String classPath() {
        return Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    public static final void scanType(Set<Class> classes, String packageName) {
        if (classes == null || StringUtils.isEmpty(packageName)) {
            return;
        }

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            Enumeration<URL> urls = loader.getResources(packageName.replaceAll("\\.", "/"));
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(url == null){
                    continue;
                }

                String protocol = url.getProtocol();
                if("file".equals(protocol)){
                    scanning(classes, new File(url.getFile()));
                }
                else if("jar".equals(protocol)){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static final void scanning(final Set<Class> classes, final File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                scanning(classes, f);
                continue;
            }
            String fileName = f.getName();
            if(fileName.endsWith(".class")){
                String className = fileName.replaceAll("\\/", "\\.");
                try {
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}