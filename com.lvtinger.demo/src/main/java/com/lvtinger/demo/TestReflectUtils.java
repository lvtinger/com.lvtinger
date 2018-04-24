package com.lvtinger.demo;

import com.lvtinger.core.common.ReflectUtils;
import com.lvtinger.demo.domain.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具测试
 *
 * @author qiuxu
 */
public class TestReflectUtils {

    @Test
    public void getDeclareField(){
        Field[] fields = ReflectUtils.getDeclareField(User.class);
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Class<? super User> superclass = User.class.getSuperclass();
        fields = ReflectUtils.getDeclareField(superclass);
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    @Test
    public void getDeclareMethod(){
        Method[] methods = ReflectUtils.getDeclareMethod(User.class);
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Class<? super User> superclass = User.class.getSuperclass();
        methods = ReflectUtils.getDeclareMethod(superclass);
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    @Test
    public void getConstructor(){
        Constructor<?>[] constructors = ReflectUtils.getDeclareConstructor(User.class);
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getParameterCount());
        }
    }

    @Test
    public void scanner() {

    }

    @Test
    public void scanType() {

    }

    @Test
    public void scanType1() {
    }

    @Test
    public void scanType2() {
    }

    @Test
    public void scanType3() {
    }

}
