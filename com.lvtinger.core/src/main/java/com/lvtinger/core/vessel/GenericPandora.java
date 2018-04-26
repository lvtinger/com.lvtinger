package com.lvtinger.core.vessel;

import com.lvtinger.core.lang.LvtingerException;
import com.lvtinger.core.vessel.hope.Hope;

import java.util.Map;
import java.util.TreeMap;

public class GenericPandora implements Pandora {
    private final Map<String, Hope> hopes = new TreeMap<>();

    @Override
    public void put(Hope hope) {
        String name = hope.getName();
        if(hopes.containsKey(name)){
            throw new LvtingerException();
        }

        hopes.put(name, hope);
    }

    @Override
    public Object get(String name) {
        Hope hope = hopes.get(name);
        if(hope == null){
            throw new LvtingerException();
        }

        Object object = hope.getHope();
        if(object == null){
            object = hope.getHope(this);
        }

        return object;
    }
}