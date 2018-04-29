package com.lvtinger.core.vessel.hope;

/**
 * @author qiuxu
 */
public class PropertyValue {
    private String name;
    private Object value;
    private int propertyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(int propertyType) {
        this.propertyType = propertyType;
    }
}