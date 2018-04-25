package com.lvtinger.core.vessel;

import com.lvtinger.core.lang.LvtingerException;
import com.lvtinger.core.vessel.hope.Hope;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author qiuxu
 */
public class GenericPandora implements Pandora {
    private Map<String, Hope> hopes = new TreeMap<>();

    @Override
    public void put(Hope hope) {
        String name = hope.getName();

        if(hopes.containsKey(name)){
            throw new LvtingerException();
        }

        hopes.put(name, hope);
    }

    @Override
    public <T> T get(Class<T> type) {
        String name = type.getName();
        Hope hope = hopes.get(name);
        if(hope == null){
            throw new LvtingerException();
        }

        return (T)hope.getObject();
    }
}
