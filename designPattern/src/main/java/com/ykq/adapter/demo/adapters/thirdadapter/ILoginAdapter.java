package com.ykq.adapter.demo.adapters.thirdadapter;

import com.ykq.adapter.demo.ResultMsg;

/**
 * @Date 2021/03/25
 * @Version v1.0.0
 */
// 声明适配器要实现的方法
public interface ILoginAdapter {
    boolean support(Object object);
    ResultMsg login(String id, Object adapter);
}
