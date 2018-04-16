package com.lvtinger.core.context.scan;

import com.lvtinger.core.context.config.ConfigContainer;

public class ClassPathResourceResolver extends ConfiguredResolver {
    public ClassPathResourceResolver(ConfigContainer container, String file) {
        super(container, new ClassPathResourceLoader(file));
    }
}
