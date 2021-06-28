package com.ykq.factory02.factoryMethod;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public class Demo {
    public static void main(String[] args) {
        JavaFactory javaFactory = new JavaFactory();
        javaFactory.create().record();

        PythonFactory pythonFactory = new PythonFactory();
        pythonFactory.create().record();
    }
}
