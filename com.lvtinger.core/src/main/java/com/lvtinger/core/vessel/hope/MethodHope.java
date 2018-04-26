package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.vessel.Pandora;
import com.lvtinger.core.vessel.value.Value;

import java.lang.reflect.Method;

public class MethodHope extends AbstractHope {

    private Value instance;
    private final Method call;
    private final Value parameters;

    public MethodHope(String name, Value object, Method call, Value parameters) {
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
