package com.ykq.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            // 可以拿到类对象，并且反射到构造方法
            Class clazz = LazyStaticInnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);

            // c.newInstance()可以任意多次使用，破坏单例只有一个全局访问点的定义
            Object instance1 = c.newInstance();
            Object instance2 = c.newInstance();
            // 可以创建多个实例，破坏单例任何情况下都绝对只有一个实例的原则
            System.out.println(instance1);
            System.out.println(instance2);
            System.out.println(instance1 == instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*   结果：
com.ykq.singleton.lazy.LazyStaticInnerClassSingleton@14ae5a5
com.ykq.singleton.lazy.LazyStaticInnerClassSingleton@7f31245a
false
*/