package com.lvtinger.core.vessel;

import com.lvtinger.core.vessel.hope.Hope;

public interface Pandora {
    void put(Hope hope);
    Object get(String name);
}