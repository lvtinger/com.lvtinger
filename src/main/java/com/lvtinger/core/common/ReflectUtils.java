package com.lvtinger.core.common;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class ReflectUtils {

    public static String classPath(){
        return Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    public static final void scanType(Set<?> sets, String packageName){
        if(StringUtils.isEmpty(packageName)){
            return;
        }
        String classPath = classPath() + StringUtils.replaceAll(packageName, "\\.", "\\/");

        File file = new File(classPath);
        if(!file.exists() || !file.isDirectory()){
            return;
        }
    }

    public static final void scanType(Set<?> set, File target){
        if(set == null || target == null || !target.isDirectory()){
            return;
        }

        File[] files = target.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                scanType(set, file);
            }else if(file.getName().endsWith(".class")){

            }
        }
    }

    /*public final List<Class<?>> findClazz(String packageName, ClazzFilter filter){
        if(StringUtils.isEmpty(packageName)){
            return Collections.EMPTY_LIST;
        }


        String path = StringUtils.replaceAll(packageName, ".", "/");

        return null;
    }*/

    public static interface ClazzFilter{
        boolean screen(Class<?> clazz);
    }
}