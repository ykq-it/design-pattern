package com.ykq.factory02.abastractFactory.factory.impl;

import com.ykq.factory02.abastractFactory.factory.ICourseFactory;
import com.ykq.factory02.abastractFactory.product.INote;
import com.ykq.factory02.abastractFactory.product.IVideo;
import com.ykq.factory02.abastractFactory.product.impl.PythonNote;
import com.ykq.factory02.abastractFactory.product.impl.PythonVideo;

/**
 * @ClassName CourseFactory
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public class PythonFactory implements ICourseFactory {
    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }
}
