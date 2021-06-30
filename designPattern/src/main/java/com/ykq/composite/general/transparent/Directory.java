package com.ykq.composite.general.transparent;

/**
 * @ClassName Component
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/29
 * @Version v1.0.0
 */
public abstract class Directory {
    abstract void show();

    abstract int getLevel();

    void addItem(Directory directory) {
        System.out.println("叶子节点不能增加子节点");
    }
}
