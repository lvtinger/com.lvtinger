package com.lvtinger.core.vessel;

import java.util.Map;
import java.util.TreeMap;

public class AbstractPandora implements Pandora {
    private Map<String, Hope> hopes = new TreeMap<>();


    @Override
    public <T> void put(Class<T> type) {
        
    }

    @Override
    public <T> void put(Class<T> type, Class<?> impl) {

    }

    @Override
    public <T> void put(Class<T> type, Class<?> impl, String name) {

    }

    @Override
    public <T> T get(Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Class<T> type, String name) {
        return null;
    }
}
