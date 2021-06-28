package com.ykq.builder.chain;

/**
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class ConcreteBuilder implements IBuilder {
    private PersonInfo personInfo = new PersonInfo();

    public ConcreteBuilder addName(String name) {
        personInfo.setName(name);
        return this;
    }
    public ConcreteBuilder addWork(String work) {
        personInfo.setWork(work);
        return this;
    }
    public ConcreteBuilder addAddress(String address) {
        personInfo.setAddress(address);
        return this;
    }

    @Override
    public Object build() {
        return personInfo;
    }
}
