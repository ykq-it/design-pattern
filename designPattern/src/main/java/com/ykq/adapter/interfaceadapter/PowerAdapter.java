package com.ykq.adapter.interfaceadapter;

/**
 * 适配器
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public class PowerAdapter implements DCTarget {
    // 接口适配器，减少了要实现的接口数量
    private AC220V ac220V;

    public PowerAdapter(AC220V ac220V) {
        this.ac220V = ac220V;
    }

    @Override
    public int output5V() {
        int input = ac220V.output220V();
        int output = input / 44;
        System.out.println("交流电输入：" + input + "; 直流电输出：" + output);
        return output;
    }

    @Override
    public int output11V() {
        int input = ac220V.output220V();
        int output = input / 20;
        System.out.println("交流电输入：" + input + "; 直流电输出：" + output);
        return output;
    }
}
