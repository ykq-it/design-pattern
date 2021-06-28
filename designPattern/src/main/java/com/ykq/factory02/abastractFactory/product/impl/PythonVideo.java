package com.ykq.factory02.abastractFactory.product.impl;

import com.ykq.factory02.abastractFactory.product.IVideo;

/**
 * @ClassName JavaVido
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("python视频");
    }
}
