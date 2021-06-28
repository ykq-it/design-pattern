package com.ykq.flyweight.dbpool;

import java.sql.Connection;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/28
 * @Version v1.0.0
 */
public class Test {
    public static void main(String[] args) {
        ConnectPool dbPool = new ConnectPool();
        Connection c1 = dbPool.getConnection();
        Connection c2 = dbPool.getConnection();
        dbPool.releaseConnection(c1);
        dbPool.releaseConnection(c2);
    }
}
