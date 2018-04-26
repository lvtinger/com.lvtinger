package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.common.ArrayUtils;
import com.lvtinger.core.lang.LvtingerException;
import com.lvtinger.core.vessel.Pandora;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GenericHope extends AbstractHope {
    private Constructor<?> constructor;
    private Value[] parameters;

    public GenericHope(String name, Constructor<?> constructor, Value... parameters) {
        super(name);
        this.constructor = constructor;
        this.parameters = parameters;
    }

    @Override
    protected Object instance(Pandora pandora) {
        if(ArrayUtils.isEmpty(parameters)){
            try {
                return constructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                throw new LvtingerException();
            }
        }

        int length = parameters.length;
        Object[] values = new Object[length];
        for (int i = 0; i < length; i++){

        }

        try {
            return constructor.newInstance(values);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new LvtingerException();
        }
    }
}
