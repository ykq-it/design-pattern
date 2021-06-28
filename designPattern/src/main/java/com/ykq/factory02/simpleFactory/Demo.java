package com.ykq.factory02.simpleFactory;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public class Demo {
    public static void main(String[] args) {
        ICourse iCourse = new JavaCourse();
        iCourse.record();

        CourseFactory.create(JavaCourse.class).record();
    }
}
