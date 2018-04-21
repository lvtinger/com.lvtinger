package com.lvtinger.core.common;

import java.util.Map;

/**
 * @author qiuxu
 */
public final class MapUtils {
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.size() == 0;
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
