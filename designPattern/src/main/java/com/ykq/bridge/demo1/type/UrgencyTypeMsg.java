package com.ykq.bridge.demo1.type;

import com.ykq.bridge.demo1.AbstractTypeMsgBridge;
import com.ykq.bridge.demo1.message.IMessage;

/**
 * @Date 2021/03/26
 * @Version v1.0.0
 */
public class UrgencyTypeMsg  extends AbstractTypeMsgBridge {
    public UrgencyTypeMsg(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public String send(String msg) {
        return "【紧急消息】" + msg;
    }
}