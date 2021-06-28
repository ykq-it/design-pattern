package com.ykq.singleton.lazy;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class ExectorThread implements Runnable {

    @Override
    public void run() {
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
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