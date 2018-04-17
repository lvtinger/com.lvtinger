package com.lvtinger.core.common;

import java.util.List;

public final class ReflectUtils {
    public final List<Class<?>> loadClazz(String packageName, ClazzFilter filter){
        return null;
    }
    public static interface ClazzFilter{
        boolean screen(Class<?> clazz);
    }
}