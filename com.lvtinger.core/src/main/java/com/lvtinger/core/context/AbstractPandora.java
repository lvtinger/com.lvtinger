package com.lvtinger.core.context;

public class AbstractPandora implements Pandora {

    @Override
    public void put(Class<?> type, Class<?> impl, String name) {

    }

    @Override
    public void put(Class<?> type, Class<?> impl) {

    }

    @Override
    public void put(Class<?> type) {

    }

    @Override
    public Object get(Class<?> type, String name) {
        return null;
    }

    @Override
    public Object get(Class<?> type) {
        return null;
    }
}