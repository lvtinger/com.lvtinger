package com.lvtinger.core.context.resolve;


import com.lvtinger.core.context.config.ConfigManage;
import com.lvtinger.core.context.config.ObjectConfig;

/**
 * @author qiuxu
 */
public abstract class AbstractResolver implements Resolver {
    private final ConfigManage configManage;

    protected ConfigManage getConfigManage(){
        return this.configManage;
    }

    protected AbstractResolver(ConfigManage configManage) {
        this.configManage = configManage;
    }

    protected void config(ObjectConfig config){
        configManage.set(config);
    }
}
