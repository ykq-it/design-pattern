package com.ykq.builder.simple;

/**
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class ConcreteBuilder implements IBuilder {
    private PersonInfo personInfo = new PersonInfo();

    public void addName(String name) {
        personInfo.setName(name);
    }
    public void addWork(String work) {
        personInfo.setWork(work);
    }
    public void addAddress(String address) {
        personInfo.setAddress(address);
    }

    @Override
    public Object build() {
        return personInfo;
    }
}
