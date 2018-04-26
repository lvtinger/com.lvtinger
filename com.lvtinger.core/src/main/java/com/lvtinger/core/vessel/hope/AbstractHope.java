package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.vessel.Pandora;
import com.lvtinger.core.vessel.value.Value;

import java.util.List;

public abstract class AbstractHope implements Hope {
    private final String name;
    private Object hope;
    private List<Value> properties;

    public AbstractHope(String name) {
        this.name = name;
    }

    public List<Value> getProperties() {
        return properties;
    }

    public void setProperties(List<Value> properties) {
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
    public Object getHope(Pandora pandora) {
        Object object = this.instance(pandora);
        this.hope = object;
        return object;
    }

    protected abstract Object instance(Pandora pandora);
}