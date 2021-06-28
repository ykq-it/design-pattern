package com.ykq.proxy.dynamicproxy.myproxy.proxy;

import java.lang.reflect.Method;

/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 15:38
 */
public interface MyInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
