package com.ykq.factory02.factoryMethod;

/**
 * @ClassName CourseFactory
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public class PythonFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
