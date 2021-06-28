package com.ykq.flyweight.general;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FlyweightFactory
 * @Description 享元工厂
 * @Author ykq
 * @Date 2021/6/28
 * @Version v1.0.0
 */
public class FlyweightFactory {
    Map<String, IMeta> metas = new HashMap<>();

    public IMeta getMeta(String key) {
        if (metas.containsKey(key)) {
            System.out.println("享元池中成功获取口令：" + key);
            return metas.get(key);
        }
        IMeta meta = new MetaService(key);
        metas.put(key, meta);
        return meta;
    }
}
