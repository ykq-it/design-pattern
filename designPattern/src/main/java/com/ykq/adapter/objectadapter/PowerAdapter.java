package com.ykq.adapter.objectadapter;

/**
 * 适配器
 * @Date 2021/03/25
 * @Version v1.0.0
 */
public class PowerAdapter implements DC5V, DC11V {
    // 要保证适配器的最少知道原则，可以不继承AC220V，而是作为私有成员属性，通过构造器初始化
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
