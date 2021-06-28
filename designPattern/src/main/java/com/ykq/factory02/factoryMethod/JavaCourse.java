package com.ykq.factory02.factoryMethod;

/**
 * @ClassName JavaCourse
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public class JavaCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("java");
    }
}
