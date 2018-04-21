package com.lvtinger.core.common;

import java.util.Set;

/**
 * Set工具类
 * @author qiuxu
 */
public final class SetUtils {
    /**
     * 判断set是否为空
     * @param set 需要判断的set
     * @return when set is null or set.isEmpty() return true else return false;
     */
    public static  boolean isEmpty(Set<?> set){
        return set == null || set.isEmpty();
    }

    /**
     * 判断set是否不为空
     * @param set 需要判断的set
     * @return return !isEmpty(set)
     */
    public static  boolean isNotEmpty(Set<?> set){
        return !isEmpty(set);
    }
}
