package com.ykq.flyweight.general;

/**
 * @ClassName MetaService
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/28
 * @Version v1.0.0
 */
public class MetaService implements IMeta {
    private String key;

    public MetaService(String key) {
        System.out.println("新建执行口令：" + key);
        this.key = key;
    }

    @Override
    public void action() {
        System.out.println("执行口令：" + key);
    }
}
