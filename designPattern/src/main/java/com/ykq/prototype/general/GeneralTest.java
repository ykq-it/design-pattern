package com.ykq.prototype.general;

/**
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class GeneralTest {
    public static void main(String[] args) {
        ConcretePrototype c1 = new ConcretePrototype();
        c1.setId(1);
        c1.setSort(1);
        System.out.println(c1);

        ConcretePrototype c2 = c1.clone();
        System.out.println(c2);
    }
}
