package com.ykq.factory02.abastractFactory.product.impl;

import com.ykq.factory02.abastractFactory.product.INote;

/**
 * @ClassName JavaNote
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public class PythonNote implements INote {
    @Override
    public void edit() {
        System.out.println("python笔记");
    }
}
