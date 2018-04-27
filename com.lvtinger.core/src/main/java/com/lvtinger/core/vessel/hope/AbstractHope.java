package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.vessel.Pandora;
import java.util.List;

public abstract class AbstractHope implements Hope {
    private final String name;
    private Object hope;
    private List<PropertyValue> properties;
    private Class<?> type;

    public AbstractHope(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    public List<PropertyValue> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyValue> properties) {
        this.properties = properties;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final Object getHope(){
        return this.hope;
    }

    @Override
    public final Object getHope(Pandora pandora) {
        Object object = this.instance(pandora);
        this.hope = object;
        return object;
    }

    protected abstract Object instance(Pandora pandora);
}