package com.ykq.adapter.demo.adapters.adapter;

import com.ykq.adapter.demo.ResultMsg;
import com.ykq.adapter.demo.adapters.thirdadapter.ILoginAdapter;
import com.ykq.adapter.demo.adapters.thirdadapter.LoginForQQAdapter;

/**
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public class PassportForThirdAdapter implements IPassportForThird {

    @Override
    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    private ResultMsg processLogin(String id, Class<? extends ILoginAdapter> clazz) {
        try {
            ILoginAdapter adapter = clazz.newInstance();
            return adapter.login(id, adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
