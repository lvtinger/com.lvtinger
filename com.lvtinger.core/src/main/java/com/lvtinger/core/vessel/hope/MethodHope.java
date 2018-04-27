package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.vessel.Pandora;

import java.lang.reflect.Method;

public class MethodHope extends AbstractHope {

    private ReferenceValue instance;
    private final Method call;
    private final Object[] parameters;

    public MethodHope(String name, Class<?> type, ReferenceValue object, Method call, Object[] parameters) {
        super(name, type);
        this.instance = object;
        this.call = call;
        this.parameters = parameters;
    }

    @Override
    protected Object instance(Pandora pandora) {

        return null;
    }
}
