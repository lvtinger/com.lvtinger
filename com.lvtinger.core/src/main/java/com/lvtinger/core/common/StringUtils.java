package com.lvtinger.core.common;

import com.lvtinger.core.lang.LvtingerException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 字符串工具类
 *
 * @author qiuxu
 */
public final class StringUtils {
    public static final String EMPTY = "";

    /**
     * 没有查找到字符串时的返回值
     */
    public static final int NO_FOUND_INDEX = -1;

    /**
     * 判断字符串为空
     *
     * @param text 将要判断的字符串
     * @return text == null or string == "" return true else return false
     */
    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    /**
     * 判断字符串不为空
     *
     * @param text 将要判断的字符串
     * @return text != null && text != "" return true else return false
     */
    public static boolean isNotEmpty(String text) {
        return !isEmpty(text);
    }

    /**
     * 字符串替换
     *
     * @param text        原始字符串
     * @param regex       字符搜索表达式
     * @param replacement 替换的字符串
     * @return 替换后的字符串
     */
    public static String replaceAll(final String text, String regex, String replacement) {
        if (text == null || regex == null || replacement == null) {
            return text;
        }

        return text.replaceAll(regex, replacement);
    }

    public static boolean equal(final String string1, final String string2){
        if(string1 == null && string1 == null){
            return true;
        }

        if(string1 == null || string2 == null){
            return false;
        }

        if(string1.length() != string2.length()){
            return false;
        }

        return string1.equals(string2);
    }

    public static Object convert(String value, Class<?> type){
        if(type == null){
            throw new LvtingerException();
        }

        if(value == null){
            return null;
        }

        if(type.equals(String.class)){
            return value;
        }else if(type.equals(Integer.class)){
           return Integer.parseInt(value);
        }else if(type.equals(Long.class)){
            return Long.parseLong(value);
        }else if(type.equals(Date.class)){
            return DateUtils.toDate(value);
        }else if(type.equals(Boolean.class)){
            String lower = value.toLowerCase();
            return lower.equals("true") || lower.equals("1");
        }else if(type.equals(Double.class)){
            return Double.parseDouble(value);
        }else if(type.equals(Float.class)){
            return Float.parseFloat(value);
        }else if(type.isEnum()){

        }

        return null;
    }
}