package com.lvtinger.demo.cache;

import com.lvtinger.core.vessel.anno.Named;

@Named("redisCache")
public class RedisCache implements Cache {
    @Override
    public String get() {
        return "redis cached";
    }
}