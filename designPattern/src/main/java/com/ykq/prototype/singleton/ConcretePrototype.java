package com.ykq.prototype.singleton;

/**
 * 具体的原型
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class ConcretePrototype implements Cloneable {
    private static final ConcretePrototype INSTANCE = new ConcretePrototype();

    private ConcretePrototype() {}

    public static ConcretePrototype getInstance() {
        return INSTANCE;
    }

    @Override
    public ConcretePrototype clone() {
//        try {
//            return (ConcretePrototype) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
        return INSTANCE;
    }
}
