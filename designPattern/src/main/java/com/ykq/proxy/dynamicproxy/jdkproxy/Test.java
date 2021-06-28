package com.ykq.proxy.dynamicproxy.jdkproxy;


import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
        personA.Hungary();

        try {
            // 输出代理类的字节码文件，再用jad反编译
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
            FileOutputStream os = new FileOutputStream("$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        IPerson personB = restaurant.getProxyPerson(new SonB());
        personB.Hungary();
    }
}
