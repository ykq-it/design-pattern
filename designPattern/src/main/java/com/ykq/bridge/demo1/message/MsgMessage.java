package com.ykq.bridge.demo1.message;

/**
 * @Date 2021/03/26
 * @Version v1.0.0
 */
public class MsgMessage implements IMessage {
    @Override
    public void send(String msg) {
        System.out.println("发送短信：" + msg);
    }
}

