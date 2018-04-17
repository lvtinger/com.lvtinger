package com.lvtinger.core.context.resolver;

import com.lvtinger.core.context.config.ConfigManage;
import com.lvtinger.core.context.config.ObjectConfig;
import com.lvtinger.core.context.scanner.AbstractScanner;
import com.lvtinger.core.context.scanner.ResourceLoader;

import java.util.List;

public class ConfiguredResolver extends AbstractScanner {
    private final ResourceLoader loader;

    public ConfiguredResolver(ConfigManage container, ResourceLoader loader) {
        super(container);
        this.loader = loader;
    }

    @Override
    protected List<ObjectConfig> scanning() {
        return null;
    }
}
