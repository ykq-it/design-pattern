package com.ykq.singleton.register;

/**
 * @Date 2021/03/22
 * @Version v1.0.0
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
