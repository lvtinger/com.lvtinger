package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.vessel.Pandora;

public class FactoryHope extends AbstractHope {
    private ReferenceHope factoryHope;
    public FactoryHope(String name, ReferenceHope factoryHope) {
        super(name);
        this.factoryHope = factoryHope;
    }

    @Override
    protected Object instance(Pandora pandora) {
        return null;
    }
}
