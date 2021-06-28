package com.ykq.flyweight.dbpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**
 * @ClassName ConnectPool
 * @Description TODO
 * @Author ykq
 * @Date 2021/6/28
 * @Version v1.0.0
 */
public class ConnectPool {
    private int poolSize = 10;
    private Vector<Connection> pool;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://101.200.177.197:3306/study";
    private String user = "customer";
    private String password = "123qwe";

    public ConnectPool() {
        pool = new Vector<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            try {
                // 1、加载驱动
                Class.forName(driver);
                // 2、创建连接
                Connection conn = DriverManager.getConnection(url, user, password);
                pool.add(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        System.out.println("取前长度：" + pool.size());
        if (pool.size() > 0) {
            Connection conn = pool.firstElement();
            pool.remove(conn);
            System.out.println("取后长度：" + pool.size());
            return conn;
        }
        return null;
    }

    public void releaseConnection(Connection conn) {
        System.out.println("释放前长度：" + pool.size());
        pool.add(conn);
        System.out.println("释放后长度：" + pool.size());
    }
}
