package com.ykq.singleton.lazy;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class LazySafeStaticInnerClassSingleton {

    private LazySafeStaticInnerClassSingleton()  {   // 私有化构造方法
        if (null != LazyHolder.LAZY_STATIC_INNER_CLASS_SINGLETON) {
            throw new RuntimeException("不允许非法访问");
        }
    }

    public static LazySafeStaticInnerClassSingleton getInstance() {  // 全局访问点
        return LazyHolder.LAZY_STATIC_INNER_CLASS_SINGLETON;
    }

    private static class LazyHolder {
        // 成员变量在加载的时候就要被分配空间，静态内部类在用的时候才分配内存。
        private static final LazySafeStaticInnerClassSingleton LAZY_STATIC_INNER_CLASS_SINGLETON = new LazySafeStaticInnerClassSingleton();
    }
}


