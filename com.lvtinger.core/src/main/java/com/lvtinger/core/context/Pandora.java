package com.lvtinger.core.context;

/**
 * 容器定义
 * @author qiuxu
 */
public interface Pandora {
    /**
     * 注册
     * @param type 类型
     * @param impl 实现
     * @param name 命名
     */
    void put(Class<?> type, Class<?> impl, String name);

    /**
     * 注册
     * @param type 类型
     * @param impl 实现
     */
    void put(Class<?> type, Class<?> impl);

    /**
     * 注册
     * @param type 类型
     */
    void put(Class<?> type);

    /**
     * 获取
     * @param type 类型
     * @param name 命名
     * @return
     */
    Object get(Class<?> type, String name);

    /**
     * 获取
     * @param type 类型
     * @return
     */
    Object get(Class<?> type);
}