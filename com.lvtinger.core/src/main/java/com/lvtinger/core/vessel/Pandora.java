package com.lvtinger.core.vessel;

import com.lvtinger.core.vessel.hope.Hope;

public interface Pandora {

    void put(Hope hope);

    <T> T get(Class<T> type);

    <T> T get(Class<T> type, String name);
}