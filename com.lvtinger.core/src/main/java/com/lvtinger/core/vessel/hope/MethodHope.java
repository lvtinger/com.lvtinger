package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.common.ArrayUtils;
import com.lvtinger.core.lang.LvtingerException;
import com.lvtinger.core.vessel.Pandora;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodHope extends AbstractHope {

    private String refer;
    private final Method call;
    private final Object[] parameters;

    public MethodHope(String name, Class<?> type, String refer, Method call, Object[] parameters) {
        super(name, type);

        this.refer = refer;
        this.call = call;
        this.parameters = parameters;
    }

    @Override
    protected Object instance(Pandora pandora) {
        Object object = pandora.get(refer);
        if(object == null){
            throw new LvtingerException();
        }

        Object[] values = null;

        if(ArrayUtils.isNotEmpty(this.parameters)){
            int length = this.parameters.length;
            values = new Object[length];
            for (int i = 0; i < length; i++){
                Object value = this.parameters[i];
                if(value instanceof ReferencedValue){
                    String referName = ((ReferencedValue) value).getName();
                    value = pandora.get(referName);
                }
                values[i] = value;
            }
        }

        try {
            return call.invoke(object, values);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new LvtingerException();
        }
    }
}