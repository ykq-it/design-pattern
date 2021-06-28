package com.ykq.adapter.interfaceadapter;

/**
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public class Test {
    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter(new AC220V());
        adapter.output5V();
        adapter.output11V();
    }
}
