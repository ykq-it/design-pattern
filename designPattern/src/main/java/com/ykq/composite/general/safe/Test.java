package com.ykq.composite.general.safe;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/29
 * @Version v1.0.0
 */
public class Test {
    public static void main(String[] args) {
        Leaf l1 = new Leaf("文件1");
        Leaf l2 = new Leaf("文件2");
        Leaf l3 = new Leaf("文件3");

        Floder f1 = new Floder("文件夹1", 1);
        f1.addItem(l1);
        f1.addItem(l2);
        f1.addItem(l3);

        Floder f2 = new Floder("文件夹2", 1);
        Floder f3 = new Floder("文件夹3", 1);

        Floder f11 = new Floder("根目录", 2);
        f11.addItem(f1);
        f11.addItem(f2);
        f11.addItem(f3);

        f11.show();
    }
}
