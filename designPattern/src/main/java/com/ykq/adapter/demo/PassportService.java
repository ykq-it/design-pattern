package com.ykq.adapter.demo;

/**
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public class PassportService {
    /**
     * 注册方法
     */
    public ResultMsg register(String name, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    /**
     * 注册后登陆的方法
     */
    public ResultMsg login(String name, String password) {
        return null;
    }
}
