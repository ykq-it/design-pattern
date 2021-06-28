package com.ykq.adapter.demo.adapters.thirdadapter;

import com.ykq.adapter.demo.PassportService;
import com.ykq.adapter.demo.ResultMsg;

/**
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {
    // extends PassportService是classAdapter，保留PassportService的原始功能

    ResultMsg loginForRegister(String name, String password) {
        if (null == password) {
            password = "THIRD_EMPTY";
        }
        super.register(name, password);
        return super.login(name, password);
    }
}
