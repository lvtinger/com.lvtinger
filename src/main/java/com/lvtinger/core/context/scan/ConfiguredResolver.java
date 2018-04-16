package com.lvtinger.core.context.scan;

import com.lvtinger.core.context.config.ConfigContainer;
import com.lvtinger.core.context.config.ObjectConfig;

import java.util.List;

public class ConfiguredResolver extends AbstractScanner{
    private final ResourceLoader loader;

    public ConfiguredResolver(ConfigContainer container, ResourceLoader loader) {
        super(container);
        this.loader = loader;
    }

    @Override
    protected List<ObjectConfig> scanning() {
        return null;
    }
}
