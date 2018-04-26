package com.lvtinger.core.vessel.hope;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class BeanHope {
    private Class<?> type;
    private String name;
    private Class<?> impl;
    private Constructor<?> constructor;
    private ReferHope factory;
    private Method called;
    private List<AttrHope> properties;
    private List<ReferHope> parameters;
    private Object bean;

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getImpl() {
        return impl;
    }

    public void setImpl(Class<?> impl) {
        this.impl = impl;
    }

    public Constructor<?> getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public ReferHope getFactory() {
        return factory;
    }

    public void setFactory(ReferHope factory) {
        this.factory = factory;
    }

    public Method getCalled() {
        return called;
    }

    public void setCalled(Method called) {
        this.called = called;
    }

    public List<AttrHope> getProperties() {
        return properties;
    }

    public void setProperties(List<AttrHope> properties) {
        this.properties = properties;
    }

    public List<ReferHope> getParameters() {
        return parameters;
    }

    public void setParameters(List<ReferHope> parameters) {
        this.parameters = parameters;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
