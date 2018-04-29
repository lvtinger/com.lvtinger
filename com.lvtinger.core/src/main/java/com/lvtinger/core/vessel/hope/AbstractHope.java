package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.common.CollectionUtils;
import com.lvtinger.core.lang.LvtingerException;
import com.lvtinger.core.vessel.Pandora;

import java.lang.reflect.Field;
import java.util.List;

public abstract class AbstractHope implements Hope {
    private final String name;
    private Object hope;
    private List<PropertyValue> properties;
    private Class<?> type;

    AbstractHope(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

//    public List<PropertyValue> getProperties() {
//        return properties;
//    }

    public void setProperties(List<PropertyValue> properties) {
        this.properties = properties;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final Object getHope(){
        return this.hope;
    }

    @Override
    public final Object getHope(Pandora pandora) {
        Object object = this.instance(pandora);

        if(CollectionUtils.isNotEmpty(this.properties)){
            for (PropertyValue propertyValue : this.properties) {
                Object value = propertyValue.getValue();
                if(value instanceof ReferencedValue){
                    value = pandora.get(((ReferencedValue) value).getName());
                }

                try {
                    Field field = type.getDeclaredField(propertyValue.getName());
                    if(!field.isAccessible()){
                        field.setAccessible(true);
                    }

                    field.set(object, value);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                    throw new LvtingerException();
                }
            }
        }
        this.hope = object;
        return object;
    }

    protected abstract Object instance(Pandora pandora);
}