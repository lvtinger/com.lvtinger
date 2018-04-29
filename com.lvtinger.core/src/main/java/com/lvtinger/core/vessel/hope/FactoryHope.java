package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.lang.LvtingerException;
import com.lvtinger.core.vessel.Pandora;

public class FactoryHope extends AbstractHope {

    private String refer;
    public FactoryHope(String name, Class<?> type, String refer) {
        super(name, type);
        this.refer = refer;
    }

    @Override
    protected Object instance(Pandora pandora) {
        Object object = pandora.get(this.refer);
        if(object instanceof HopeFactory){
            return ((HopeFactory) object).create();
        }
        throw new LvtingerException();
    }
}