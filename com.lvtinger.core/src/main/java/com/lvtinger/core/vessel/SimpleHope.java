package com.lvtinger.core.vessel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SimpleHope extends AbstractHope {
    private Constructor<?> constructor = null;
    private Object instance;

    public SimpleHope(Class<?> type, String name) {
        super(type, name);
        try {
            constructor = type.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object instance() {
        if (this.instance != null) {
            return this.instance;
        }

        try {
            this.instance = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return this.instance;
    }
}
