package com.lvtinger.core.context.resolver;

import com.lvtinger.core.context.config.ConfigManage;
import com.lvtinger.core.context.scanner.ClassPathResourceLoader;

public class ClassPathResourceResolver extends ConfiguredResolver {
    public ClassPathResourceResolver(ConfigManage container, String file) {
        super(container, new ClassPathResourceLoader(file));
    }
}
