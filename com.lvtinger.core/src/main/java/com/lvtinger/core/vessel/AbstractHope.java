package com.lvtinger.core.vessel;

public abstract class AbstractHope implements Hope {
    private Class<?> type;
    private String name;

    public AbstractHope(Class<?> type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public Class<?> getHopeType() {
        return type;
    }

    @Override
    public String getHopeName() {
        return name;
    }
}
