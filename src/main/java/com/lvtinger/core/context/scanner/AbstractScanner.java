package com.lvtinger.core.context.scanner;

import com.lvtinger.core.context.config.ConfigManage;
import com.lvtinger.core.context.config.ObjectConfig;
import com.lvtinger.core.context.resolver.ConfigResolver;

import java.util.List;

public abstract class AbstractScanner implements ConfigResolver {
    private final ConfigManage container;

    public AbstractScanner(ConfigManage container) {
        this.container = container;
    }

    protected abstract List<ObjectConfig> scanning();

    @Override
    public void scan() {
        List<ObjectConfig> configs = scanning();
        for (ObjectConfig config : configs) {
            if (config == null) {
                continue;
            }

            container.set(config);
        }
    }
}
