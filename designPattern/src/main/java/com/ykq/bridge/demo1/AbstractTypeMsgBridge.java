package com.ykq.bridge.demo1;

import com.ykq.bridge.demo1.message.IMessage;

/**
 * @Date 2021/03/26
 * @Version v1.0.0
 */
public abstract class AbstractTypeMsgBridge {
    private IMessage iMessage;

    public AbstractTypeMsgBridge(IMessage iMessage) {
        this.iMessage = iMessage;
    }

    public abstract String send(String msg);

    public void sendMsg(String msg) {
        String msg1 = this.send(msg);
        iMessage.send(msg1);
    }
}