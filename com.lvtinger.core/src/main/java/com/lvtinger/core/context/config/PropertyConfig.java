package com.lvtinger.core.context.config;

import com.lvtinger.core.common.StringUtils;
import com.lvtinger.core.lang.LvtingerException;

import java.util.LinkedList;
import java.util.List;

/**
 * 属性配置
 * @author qiuxu
 */
public class PropertyConfig {
    private List<ValueConfig> propertyConfigs = new LinkedList<>();

    public void attach(ValueConfig config){
        if(config == null || StringUtils.isEmpty(config.getName())){
            throw new LvtingerException();
        }

        if(propertyConfigs.stream().filter(x->x.getName().equals(config.getName())).count() > 0){
            throw new LvtingerException();
        }

        propertyConfigs.add(config);
    }
}
