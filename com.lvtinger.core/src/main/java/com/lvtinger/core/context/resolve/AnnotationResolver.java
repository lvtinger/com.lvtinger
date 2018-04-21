package com.lvtinger.core.context.resolve;

/**
 * @author qiuxu
 */
public class AnnotationResolver extends AbstractResolver {
    private final String packageName;

    public AnnotationResolver(String packageName) {
        this.packageName = packageName;
    }

}