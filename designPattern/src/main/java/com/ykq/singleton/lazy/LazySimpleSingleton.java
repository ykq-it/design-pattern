package com.ykq.singleton.lazy;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
/**
 * 优点：解决内存浪费的问题
 * 缺点：线程不安全
 */
public class LazySimpleSingleton {
    // 只有一个实例
    public static LazySimpleSingleton LAZY_SIMPLE_SINGLETON;

    private LazySimpleSingleton() {
    }   // 私有化构造方法

    public static LazySimpleSingleton getInstance() {  // 全局访问点
        if (null == LAZY_SIMPLE_SINGLETON) {
            LAZY_SIMPLE_SINGLETON = new LazySimpleSingleton();
        }
        return LAZY_SIMPLE_SINGLETON;
    }
}
/*
运行结果
同一个实例
1、正常顺序执行
2、创建了两个实例，但后者覆盖前者
不同的实例
同时进入了条件，但按顺序返回
*/
