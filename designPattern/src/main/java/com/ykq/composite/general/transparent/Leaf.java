package com.ykq.composite.general.transparent;

/**
 * @ClassName Leaf
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/29
 * @Version v1.0.0
 */
public class Leaf extends Directory {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(name);
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
