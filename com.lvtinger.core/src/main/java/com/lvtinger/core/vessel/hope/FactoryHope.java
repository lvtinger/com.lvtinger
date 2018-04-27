package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.vessel.Pandora;

public class FactoryHope extends AbstractHope {
    private ReferenceValue factory;
    public FactoryHope(String name, Class<?> type, ReferenceValue factory) {
        super(name, type);
        this.factory = factory;
    }

    @Override
    protected Object instance(Pandora pandora) {
        return null;
    }
}
