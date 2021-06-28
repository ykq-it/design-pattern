package com.ykq.bridge.demo1.type;

import com.ykq.bridge.demo1.AbstractTypeMsgBridge;
import com.ykq.bridge.demo1.message.IMessage;

/**
 * @Date 2021/03/26
 * @Version v1.0.0
 */
public class NormalTypeMsg extends AbstractTypeMsgBridge {
    public NormalTypeMsg(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public String send(String msg) {
        return "【普通消息】" + msg;
    }
}
