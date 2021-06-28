package com.ykq.factory02.refactorJdbcPool.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * @ClassName DbConnectionPool
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/20
 * @Version v1.0.0
 */
public class DbConnectionPool extends Pool {
    /** 数据库连接池实例*/
    private static DbConnectionPool pool = null;
    private String username = null;
    private String password = null;
    private String url = null;

    /** 存放产生的连接 */
    private Vector<Connection> freeConnections = new Vector<>();
    /** 当前空闲连接数 */
    private static int num = 0;
    /** 已使用连接数 */
    private int checkedOut = 0;
    /** TODO 当前可用连接数 */
    private int numActive = 0;

    // 单例模式，返回数据库连接池Pool的实例
    public static synchronized DbConnectionPool getInstance() throws Exception {
        if (null == pool) {
            pool = new DbConnectionPool();
        }
        return pool;
    }

    private DbConnectionPool() {
        try {
            init();
            // 先创建常用连接数个连接
            for (int i = 0; i < normalConnect; i++) {
                Connection connection = newConnection();
                if (null != connection) {
                    // 容器中添加连接对象
                    freeConnections.addElement(connection);
                    // 记录空闲连接数
                    num++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 创建一个新的连接
    private Connection newConnection() {
        Connection connection = null;
        try {
            if (null == username) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
            System.out.println("连接池创建了一个新的连接");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接池无法创建一个新的连接");
            return null;
        }
    }

    // 初始化
    private void init() throws IOException {
        InputStream inputStream = Pool.class.getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(inputStream);
        this.url = properties.getProperty("url");
        this.username = properties.getProperty("username");
        this.password = properties.getProperty("password");
        this.driverName = properties.getProperty("DriverClassName");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    @Override
    public void createPool() {
        pool = new DbConnectionPool();
        if (null != pool) {
            System.out.println("数据库连接池创建成功");
        } else {
            System.out.println("数据库连接池创建失败");
        }
    }

    // 单例模式，获取一个可用连接
    @Override
    public Connection getConnection() {
        Connection connection = null;
        if (freeConnections.size() > 0) {
            num--;
            connection = freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (connection.isClosed()) {
                    System.out.println("从连接池中删除一个无效连接");
                    connection = getConnection();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("从连接池中删除一个无效连接");
                connection = getConnection();
            }
        } else if (maxConnect == 0 || checkedOut < maxConnect) {
            connection = newConnection();
        }
        if (null != connection) {
            checkedOut++;
        }
        numActive++;
        return connection;
    }

    @Override
    public Connection getConnection(long time) {
        Connection connection = null;
        long startTime = System.currentTimeMillis();
        while ((connection = getConnection()) == null) {
            try {
                wait(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((System.currentTimeMillis() - startTime) > time) {
                return null;
            }
        }
        return connection;
    }

    @Override
    public void freeConnection(Connection conn) {
        freeConnections.addElement(conn);
        num++;
        checkedOut--;
        numActive--;
        // 解锁
        notifyAll();
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public int getNumActive() {
        return numActive;
    }

    // 撤销驱动
    @Override
    public synchronized void release() {
        try {
            // 将当前所有连接赋值到枚举中
            Enumeration allConnections = freeConnections.elements();
            // 使用循环关闭所有连接
            while (allConnections.hasMoreElements()) {
                // 如果此枚举至少还有一个可提供的元素，则返回下一个元素
                Connection connection = (Connection) allConnections.nextElement();
                try {
                    connection.close();
                    num--;
                } catch (Exception e) {
                e.printStackTrace();
                System.out.println("无法关闭连接池中的连接");
                }
            }
            freeConnections.removeAllElements();
            numActive = 0;
        } finally {
            super.release();
        }
    }
}
