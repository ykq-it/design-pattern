package com.ykq.adapter.demo.adapters.thirdadapter;

import com.ykq.adapter.demo.ResultMsg;

/**
 * @ClassName LoginForQQAdapter
 * @Description TODO
 * @Author ykq
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public class LoginForQQAdapter extends AbstractAdapter {
    @Override
    public boolean support(Object object) {
        return object instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        if (!support(adapter)) {
            return null;
        }
        return super.loginForRegister(id, null);
    }
}
