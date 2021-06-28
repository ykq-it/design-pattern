package com.ykq.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
// Spring的bean也是单例的
public class ContainerSngleton {
    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className) {
        if (!ioc.containsKey(className)) {
            try {
                ioc.put(className, Class.forName(className));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return ioc.get(className);
    }
}
