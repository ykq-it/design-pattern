package com.ykq.adapter.demo.adapters.adapter;

import com.ykq.adapter.demo.ResultMsg;

/**
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public interface IPassportForThird {
    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);
}
