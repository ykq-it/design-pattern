package com.ykq.composite.general.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Composite
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/29
 * @Version v1.0.0
 */
public class Floder implements Directory {
    private String name;

    private int level;

    private List<Directory> items = new ArrayList<>();

    @Override
    public int getLevel() {
        return level;
    }

    public Floder(String name, int level) {
        this.name = name;
        this.level = level;
    }

    void addItem(Directory direcotry) {
        items.add(direcotry);
    }

    @Override
    public void show() {
        System.out.println(this.name);
        for (Directory d : items) {
            if (d.getLevel() == 1) {
                System.out.print("    +-");
            } else if (d.getLevel() == 0) {
                System.out.print("        +-");
            }
            d.show();
        }
    }
}
