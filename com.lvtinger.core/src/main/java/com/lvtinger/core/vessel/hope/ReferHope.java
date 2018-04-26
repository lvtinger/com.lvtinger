package com.lvtinger.core.vessel.hope;

public class ReferHope {
    private String name;
    private Class<?> type;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ReferHope() {
    }

    public ReferHope(Class<?> type) {
        this.type = type;
    }

    public ReferHope(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    public ReferHope(String value) {
        this.value = value;
    }
}