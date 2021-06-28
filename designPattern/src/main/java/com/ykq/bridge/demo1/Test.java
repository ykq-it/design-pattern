package com.ykq.bridge.demo1;

import com.ykq.bridge.demo1.message.EmailMessage;
import com.ykq.bridge.demo1.message.IMessage;
import com.ykq.bridge.demo1.message.MsgMessage;
import com.ykq.bridge.demo1.type.NormalTypeMsg;
import com.ykq.bridge.demo1.type.UrgencyTypeMsg;

/**
 * @Date 2021/03/26
 * @Version v1.0.0
 */
public class Test {
    public static void main(String[] args) {
        IMessage message = new MsgMessage();
        AbstractTypeMsgBridge msg = new NormalTypeMsg(message);
        msg.sendMsg("放假了");

        message = new EmailMessage();
        msg = new UrgencyTypeMsg(message);
        msg.sendMsg("收作业");
    }
}
