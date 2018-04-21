package com.lvtinger.core.context.config;

import com.lvtinger.core.common.StringUtils;
import com.lvtinger.core.lang.LvtingerException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author qiuxu
 */
public class ConfigManage {
    private final Map<String, ObjectConfig> map = new HashMap<>();

    public ObjectConfig get(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new LvtingerException();
        }

        ObjectConfig config = map.get(name);

        if (config == null) {
            throw new LvtingerException();
        }

        return config;
    }

    public void set(ObjectConfig config) {
        Objects.requireNonNull(config);
        String name = config.getName();
        if (map.containsKey(name)) {
            throw new LvtingerException();
        }

        map.put(name, config);
    }
}