package com.ykq.adapter.classadapter;

/**
 * 适配器
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public class PowerAdapter extends AC220V implements DC5V, DC11V {
    @Override
    public int output5V() {
        int input = super.output220V();
        int output = input / 44;
        System.out.println("交流电输入：" + input + "; 直流电输出：" + output);
        return output;
    }

    @Override
    public int output11V() {
        int input = super.output220V();
        int output = input / 20;
        System.out.println("交流电输入：" + input + "; 直流电输出：" + output);
        return output;
    }
}
