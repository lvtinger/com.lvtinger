package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.vessel.Pandora;
import com.lvtinger.core.vessel.value.Value;

public class FactoryHope extends AbstractHope {
    private Value factoryHope;
    public FactoryHope(String name, Value factoryHope) {
        super(name);
        this.factoryHope = factoryHope;
    }

    @Override
    protected Object instance(Pandora pandora) {
        return null;
    }
}
