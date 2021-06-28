package com.ykq.factory02.abastractFactory.factory;

import com.ykq.factory02.abastractFactory.product.INote;
import com.ykq.factory02.abastractFactory.product.IVideo;

/**
 * @ClassName ICourseFactory
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public interface ICourseFactory {
    INote createNote();

    IVideo createVideo();
}
