package com.ykq.builder.chain;

/**
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class Test {
    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();
        ((ConcreteBuilder) builder).addName("张三")
                .addWork("工程师")
                .addAddress("北京");

        System.out.println(builder.build());
    }
}
