package com.ykq.proxy.dynamicproxy.jdkproxy;

/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 13:43
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 代理类不要求是Person的实现了 */
public class Restaurant implements InvocationHandler {
    private IPerson person;
    
    public IPerson getProxyPerson(IPerson person) {
        this.person = person;
        Class clazz = person.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.person, args);
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
