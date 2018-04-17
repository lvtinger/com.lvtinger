package com.lvtinger.core.context.resolver;

import com.lvtinger.core.context.config.ConfigManage;
import com.lvtinger.core.context.config.ObjectConfig;
import com.lvtinger.core.context.scanner.AbstractScanner;

import java.util.List;

public class AnnotationResolver extends AbstractScanner {
    private final String packageName;

    public AnnotationResolver(ConfigManage container, String packageName) {
        super(container);
        this.packageName = packageName;
    }

    @Override
    protected List<ObjectConfig> scanning() {
        return null;
    }
}
