package com.ykq.singleton.threadLocal;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class ThreadLocalSingleton {

    public static final ThreadLocal<ThreadLocalSingleton> THREAD_LOCAL_INSTANCE =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton() {}

    public static ThreadLocalSingleton getInstance() {
        return THREAD_LOCAL_INSTANCE.get();
    }
}
