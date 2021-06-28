package com.ykq.builder.general;

/**
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class Test {
    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();
        System.out.println(builder.build());
    }
}
