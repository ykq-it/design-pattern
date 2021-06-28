package com.ykq.singleton.threadLocal;

/**
 * @ClassName ThreadLocalTest
 * @Description TODO
 * @Author ykq
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start(); // 有资格抢CPU资源了
        t2.start();

        System.out.println("End");
    }
}
