package com.lvtinger.core.context.config;

import java.util.List;

/**
 * @author qiuxu
 */
public class ObjectConfig{

    private Class<?> clazz;
    private String name;
    private List<ValueConfig> properties;

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ValueConfig> getProperties() {
        return properties;
    }

    public void setProperties(List<ValueConfig> properties) {
        this.properties = properties;
    }
}