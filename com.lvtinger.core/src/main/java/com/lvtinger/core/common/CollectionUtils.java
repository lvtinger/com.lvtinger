package com.lvtinger.core.common;

import java.util.Collection;

/**
 * @author qiuxu
 */
public final class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
