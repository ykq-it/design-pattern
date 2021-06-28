package com.ykq.singleton.serializable;

import java.io.Serializable;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public class SerializableSingleton implements Serializable {
    // 序列化：把内存中的对象转为字节码，再把字节码通过IO输出流写到磁盘上，让它永久保存下来。
    // 反序列化：将持久化的字节码内容，通过IO输入流读到内存，再把字节码转为对象

    private final static SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton() {
    }

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

//    桥接模式
    private Object readResolve() {
        return INSTANCE;
    }
}
