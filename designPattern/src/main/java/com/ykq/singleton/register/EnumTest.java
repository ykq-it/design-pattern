package com.ykq.singleton.register;

/**
 * @ClassName EnumTest
 * @Description TODO
 * @Author ykq
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class EnumTest {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());
    }
}
