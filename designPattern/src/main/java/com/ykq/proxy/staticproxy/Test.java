package com.ykq.proxy.staticproxy;


/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 13:22
 */
public class Test {
    public static void main(String[] args) {
        ProxyMomA mom = new ProxyMomA(new SonA());
        mom.Hungary();
    }
}
