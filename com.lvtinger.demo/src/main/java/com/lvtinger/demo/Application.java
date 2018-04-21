package com.lvtinger.demo;

import com.lvtinger.core.common.ReflectUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author qiuxu
 */
public class Application {
    public static void main(String... args) {

        Set<Class<?>> classes = new LinkedHashSet<>();
        ReflectUtils.scanType(Application.class.getClassLoader(), classes, "com.lvtinger.core");
        ReflectUtils.scanType(Application.class.getClassLoader(), classes, "org.junit.runner");

        for (Class<?> clazz : classes) {
            System.out.println(clazz.getName());
        }
    }
}