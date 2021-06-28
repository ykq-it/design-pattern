package com.ykq.proxy.dynamicproxy.cglibproxy;

/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 13:43
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/** 代理类不要求是Person的实现了 */
public class Restaurant implements MethodInterceptor {
    // 不需要声明IPerson的私有变量了，SonA也不用实现IPerson了，因为跟JDKProxy比较，invoke时不需要传接口类型
    public Object getProxyPerson(Class clazz) {
        // cglib生成字节码的工具
        Enhancer enhancer = new Enhancer();
        // 相当于代理类继承父类clazz
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println("饭店，买菜做饭");
    }

    private void after() {
        System.out.println("饭店，刷锅洗碗");
    }
}
