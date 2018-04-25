package com.lvtinger.core.vessel;

public interface Pandora {
    <T> void put(Class<T> type);

    <T> void put(Class<T> type, Class<?> impl);

    <T> void put(Class<T> type, Class<?> impl, String name);

    <T> T get(Class<T> type);

    <T> T get(Class<T> type, String name);
}