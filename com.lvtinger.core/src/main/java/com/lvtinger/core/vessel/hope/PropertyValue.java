package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.vessel.value.Value;

public class PropertyValue {
    private String name;
    private Value value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}