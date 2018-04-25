package com.lvtinger.core.vessel.hope;

import com.lvtinger.core.lang.LvtingerException;

public class Hope {
    private String name;
    private Class<?> type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    private Object object;

    public Object getObject(){
        if(object == null){
            try {
                object = type.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                throw new LvtingerException();
            }
        }
        return object;
    }
}