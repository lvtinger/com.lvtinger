package com.lvtinger.core.context.scan;

import com.lvtinger.core.context.config.ConfigContainer;
import com.lvtinger.core.context.config.ObjectConfig;

import java.util.List;

public class AnnotationResolver extends AbstractScanner {
    private final String packageName;

    public AnnotationResolver(ConfigContainer container, String packageName) {
        super(container);
        this.packageName = packageName;
    }

    @Override
    protected List<ObjectConfig> scanning() {
        return null;
    }
}
