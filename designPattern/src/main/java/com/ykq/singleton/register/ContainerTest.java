package com.ykq.singleton.register;

/**
 * @ClassName ContainerTest
 * @Description TODO
 * @Author ykq
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class ContainerTest {
    public static void main(String[] args) {
        Object instance1 = ContainerSngleton.getInstance("com.ykq.singleton.registe.Pojo");
        Object instance2 = ContainerSngleton.getInstance("com.ykq.singleton.registe.Pojo");
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
