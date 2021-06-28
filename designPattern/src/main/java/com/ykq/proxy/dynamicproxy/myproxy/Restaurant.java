package com.ykq.proxy.dynamicproxy.myproxy;

/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 13:43
 */

import com.ykq.proxy.dynamicproxy.myproxy.proxy.MyClassLoader;
import com.ykq.proxy.dynamicproxy.myproxy.proxy.MyInvocationHandler;
import com.ykq.proxy.dynamicproxy.myproxy.proxy.MyProxy;

import java.lang.reflect.Method;

/** 代理类不要求是Person的实现了 */
public class Restaurant implements MyInvocationHandler {
    private IPerson person;
    
    public IPerson getProxyPerson(IPerson person) {
        this.person = person;
        Class clazz = person.getClass();
        return (IPerson) MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
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
