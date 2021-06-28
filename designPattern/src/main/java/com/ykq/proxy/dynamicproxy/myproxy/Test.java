package com.ykq.proxy.dynamicproxy.myproxy;

/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 13:22
 */
public class Test {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        IPerson personA = restaurant.getProxyPerson(new SonA());
        personA.hungary();
    }
}
