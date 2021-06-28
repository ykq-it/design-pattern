package com.ykq.proxy.staticproxy;

/**
 * 功能描述：
 *
 * @author: ykq
 * @date: 2021/3/24 13:05
 */
public class ProxyMomA implements IPerson {

    private IPerson subject;

    public ProxyMomA(IPerson subject) {
        this.subject = subject;
    }

    @Override
    public void Hungary() {
        before();
        subject.Hungary();
        after();
    }

    private void before() {
        System.out.println("A妈先，买菜做饭");
    }

    private void after() {
        System.out.println("A妈后，刷锅洗碗");
    }
}
