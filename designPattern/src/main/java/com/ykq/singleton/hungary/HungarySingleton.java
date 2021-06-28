package com.ykq.singleton.hungary;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
/**
 * 优点：执行效率高，性能高。简单，没有锁
 * 缺点：1、类加载时初始化，不管用不用都要初始化，可能会导致内存浪费。如果有大量需要单例的类，则不适合
 */
public class HungarySingleton {
    // 只有一个实例
    public static final HungarySingleton HUNGARY_SINGLETON = new HungarySingleton();

    private HungarySingleton() {
    }   // 私有化构造方法

    public static HungarySingleton getInstance() {  // 全局访问点
        return HUNGARY_SINGLETON;
    }
}
