package com.ykq.singleton.hungary;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class HungaryStaticSingleton {
    // 只有一个实例
    public static final HungaryStaticSingleton HUNGARY_SINGLETON;

    // 先静态后动态，先上后下，先属性后方法
    static {    // 静态的代码块，在类加载时初始化
        HUNGARY_SINGLETON = new HungaryStaticSingleton();
    }

    private HungaryStaticSingleton() {
    }   // 私有化构造方法

    public static HungaryStaticSingleton getInstance() {  // 全局访问点
        return HUNGARY_SINGLETON;
    }
}
