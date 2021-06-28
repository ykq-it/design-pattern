package com.ykq.flyweight.general;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/28
 * @Version v1.0.0
 */
public class Test {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        factory.getMeta("1").action();
        factory.getMeta("1").action();
        factory.getMeta("2").action();
    }
}
