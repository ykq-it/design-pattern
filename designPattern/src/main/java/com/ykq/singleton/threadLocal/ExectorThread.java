package com.ykq.singleton.threadLocal;

import com.ykq.singleton.lazy.LazyDoubleCheckSingleton;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class ExectorThread implements Runnable {

    @Override
    public void run() {
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }

//    @Override
//    public void run() {
//        LazyMethodLockSingleton instance = LazyMethodLockSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName() + ":" + instance);
//    }

//    @Override
//    public void run() {
//        LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName() + ":" + instance);
//    }
}