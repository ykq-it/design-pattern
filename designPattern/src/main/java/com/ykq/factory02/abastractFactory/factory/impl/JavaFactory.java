package com.ykq.factory02.abastractFactory.factory.impl;

import com.ykq.factory02.abastractFactory.factory.ICourseFactory;
import com.ykq.factory02.abastractFactory.product.INote;
import com.ykq.factory02.abastractFactory.product.IVideo;
import com.ykq.factory02.abastractFactory.product.impl.JavaNote;
import com.ykq.factory02.abastractFactory.product.impl.JavaVideo;

/**
 * @ClassName CourseFactory
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public class JavaFactory implements ICourseFactory {

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
