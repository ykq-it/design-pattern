package com.ykq.builder.chain;

/**
 * @Date 2021/03/23
 * @Version v1.0.0
 */
public class PersonInfo {
    private String name;
    private String work;
    private String address;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "name='" + name + '\'' +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
