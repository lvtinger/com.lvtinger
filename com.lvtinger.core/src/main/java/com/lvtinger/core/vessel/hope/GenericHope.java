package com.lvtinger.core.vessel.hope;

import java.lang.reflect.Constructor;

public class GenericHope extends AbstractHope {
    private Constructor<?> constructor;
    private ReferenceHope[] parameters;

    public GenericHope(String name, Constructor<?> constructor, ReferenceHope... parameters) {
        super(name);
        this.constructor = constructor;
        this.parameters = parameters;
    }
}
