package com.lvtinger.core.context.factory;

import com.lvtinger.core.context.config.ObjectConfig;
import com.lvtinger.core.lang.LvtingerException;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author qiuxu
 */
public abstract class AbstractObjectFactory implements ObjectFactory {
    private final Map<String, Object> map = new TreeMap<String, Object>();

    @Override
    public Object get(String name) {
        return null;
    }

    public void put(ObjectConfig config) {
        if (map.containsKey(config.getName())) {
            throw new LvtingerException();
        }
        map.put(config.getName(), config);
    }

    private Object instance(ObjectConfig config) {

        return null;
    }
}
