package com.ykq.singleton.lazy;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class LazyTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start(); // 有资格抢CPU资源了
        t2.start();

        System.out.println("End");
    }
}
