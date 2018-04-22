package com.lvtinger.core.context.config;

import com.lvtinger.core.common.StringUtils;

/**
 * @author qiuxu
 */
public class ObjectConfig {

    private Class<?> clazz;
    private String name;
    private PropertyConfig properties;

    public Class<?> getClazz() {
        return clazz;
    }

    public String getName() {
        return name;
    }

    public PropertyConfig getProperties() {
        return properties;
    }

    public ObjectConfig(Class<?> clazz, String name, PropertyConfig properties) {
        if(clazz == null || StringUtils.isEmpty(name)){
            throw new NullPointerException();
        }
        this.clazz = clazz;
        this.name = name;
        this.properties = properties;
    }
}