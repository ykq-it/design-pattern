package com.ykq.prototype.singleton;

/**
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class GeneralTest {
    public static void main(String[] args) {
        ConcretePrototype c1 = ConcretePrototype.getInstance();

        ConcretePrototype c2 = c1.clone();
        System.out.println("克隆对象：" + c2);
        System.out.println("原型对象：" + c1);
        System.out.println(c1 == c2);
    }
}
