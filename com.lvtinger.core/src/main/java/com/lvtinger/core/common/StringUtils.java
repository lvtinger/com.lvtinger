package com.lvtinger.core.common;

/**
 * 字符串工具类
 * @author qiuxu
 */
public final class StringUtils {
    /**
     * 没有查找到字符串时的返回值
     */
    public static final int NO_FOUND_INDEX = -1;

    /**
     * 判断字符串为空
     * @param text 将要判断的字符串
     * @return text == null or string == "" return true else return false
     */
    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    /**
     * 判断字符串不为空
     * @param text 将要判断的字符串
     * @return text != null && text != "" return true else return false
     */
    public static boolean isNotEmpty(String text) {
        return !isEmpty(text);
    }

    /**
     * 字符串替换
     * @param text 原始字符串
     * @param regex 字符搜索表达式
     * @param replacement 替换的字符串
     * @return 替换后的字符串
     */
    public static String replaceAll(final String text, String regex, String replacement){
        if(text == null || regex == null || replacement == null){
            return text;
        }

        return text.replaceAll(regex, replacement);
    }
}