package com.ykq.adapter.demo.adapters;

import com.ykq.adapter.demo.adapters.adapter.IPassportForThird;
import com.ykq.adapter.demo.adapters.adapter.PassportForThirdAdapter;

/**
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public class Test {
    public static void main(String[] args) {
        IPassportForThird passport = new PassportForThirdAdapter();
        passport.loginForWechat("1");
    }
}
