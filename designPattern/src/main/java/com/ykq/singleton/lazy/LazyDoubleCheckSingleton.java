package com.ykq.singleton.lazy;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class LazyDoubleCheckSingleton {
    // 只有一个实例
    public volatile static LazyDoubleCheckSingleton LAZY_SIMPLE_SINGLETON;

    private LazyDoubleCheckSingleton() {
    }   // 私有化构造方法

    public static LazyDoubleCheckSingleton getInstance() {  // 全局访问点
        if (null == LAZY_SIMPLE_SINGLETON) {    // 第一次检查是否要阻塞
            synchronized (LazyDoubleCheckSingleton.class) {
                if (null == LAZY_SIMPLE_SINGLETON) {    // 第二次检查是否创建实例
                    LAZY_SIMPLE_SINGLETON = new LazyDoubleCheckSingleton();
                    // 可能会出现指令重排序的问题。线程环境要抢时间片，有一定的随机性，在这一步又要分配实例的内存地址，
                    // 也要分配变量的内存地址，可能出现先后问题，导致线程紊乱。所以要加volatile
                }
            }
        }
        return LAZY_SIMPLE_SINGLETON;
    }
}
