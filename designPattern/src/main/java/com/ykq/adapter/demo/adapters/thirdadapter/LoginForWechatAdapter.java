package com.ykq.adapter.demo.adapters.thirdadapter;

import com.ykq.adapter.demo.ResultMsg;

/**
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public class LoginForWechatAdapter extends AbstractAdapter {
    @Override
    public boolean support(Object object) {
        return object instanceof LoginForWechatAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        if (!support(adapter)) {
            return null;
        }
        return super.loginForRegister(id, null);
    }
}
