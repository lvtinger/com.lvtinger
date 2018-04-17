package com.lvtinger.core.context.resolve;

import com.lvtinger.core.context.config.ConfigManage;

/**
 * @author qiuxu
 */
public interface Resolver {
    void resolve(ConfigManage manage);
}
