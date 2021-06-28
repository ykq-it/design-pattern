package com.ykq.singleton.register;

import java.lang.reflect.Constructor;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            Object instance1 = c.newInstance();
            System.out.println(instance1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}