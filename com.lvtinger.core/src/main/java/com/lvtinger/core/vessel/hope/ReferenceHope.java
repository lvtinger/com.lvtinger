package com.lvtinger.core.vessel.hope;

public class ReferenceHope {
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

    public ReferenceHope() {
    }

    public ReferenceHope(Class<?> type) {
        this.type = type;
    }

    public ReferenceHope(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    public ReferenceHope(String value) {
        this.value = value;
    }
}