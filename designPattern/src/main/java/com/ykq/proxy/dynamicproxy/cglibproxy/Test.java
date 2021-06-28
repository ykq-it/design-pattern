package com.ykq.proxy.dynamicproxy.cglibproxy;


import com.ykq.proxy.dynamicproxy.jdkproxy.IPerson;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 13:22
 */
public class Test {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\workspaceGPer\\designPattern");

        Restaurant restaurant = new Restaurant();
        SonA personA = (SonA) restaurant.getProxyPerson(SonA.class);
        personA.hungary();


        SonB personB = (SonB) restaurant.getProxyPerson(SonB.class);
        personB.hungary();
    }
}
