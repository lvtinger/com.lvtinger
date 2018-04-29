package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.common.ArrayUtils;
import com.lvtinger.core.lang.LvtingerException;
import com.lvtinger.core.vessel.Pandora;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GenericHope extends AbstractHope {
    private Constructor<?> constructor;
    private Object[] parameters;

    public GenericHope(String name, Class<?> type) {
        super(name, type);

        try {
           this.constructor = type.getConstructor();
           this.parameters = null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new LvtingerException();
        }
    }

    public GenericHope(String name, Class<?> type, Constructor<?> constructor, Object... parameters) {
        super(name, type);
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
            Object parameter = parameters[i];

            if(parameter instanceof ReferValue){
                String referName = ((ReferValue) parameter).getReferName();
                parameter = pandora.get(referName);
            }

            values[i] = parameter;
        }

        try {
            return constructor.newInstance(values);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new LvtingerException();
        }
    }
}
