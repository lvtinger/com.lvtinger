package com.lvtinger.core.context.scan;

import com.lvtinger.core.context.config.ConfigContainer;
import com.lvtinger.core.context.config.ObjectConfig;

import java.util.List;

public abstract class AbstractScanner implements ConfigResolver {
    private final ConfigContainer container;

    public AbstractScanner(ConfigContainer container) {
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
