package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.vessel.Pandora;

import java.lang.reflect.Method;

public class MethodHope extends AbstractHope {

    private ReferenceHope instance;
    private final Method call;
    private final ReferenceHope parameters;

    public MethodHope(String name, ReferenceHope object, Method call, ReferenceHope parameters) {
        super(name);
        this.instance = object;
        this.call = call;
        this.parameters = parameters;
    }

    @Override
    protected Object instance(Pandora pandora) {
        return null;
    }
}
