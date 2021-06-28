package com.ykq.factory02.refactorJdbcPool.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 自定义数据库连接池geInstance()，返回Pool的唯一实例，第一次调用时将执行构造函数
 * 构造函数Pool()调用驱动装载loadDrivers()函数
 * createPool()创建连接池
 * getConnection()返回一个连接实例，getConnection(long time)添加时间限制
 * freeConnection(Connection conn)将conn连接实例返回连接池
 * getNum()返回空闲连接数
 * getNumActive()返回当前使用的连接数
 */
public abstract class Pool {

    public String propertiesName = "db.properties";

    /** Pool的唯一实例 */
    private static Pool instance = null;

    /** 驱动字符串 */
    protected String driverName = null;

    /** 驱动 */
    protected Driver driver = null;

    /** 最大连接数 */
    protected int maxConnect = 100;

    /** 保持连接数 */
    protected int normalConnect = 10;

    protected Pool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 初始化所有从配置文件读取的成员变量
    private void init() throws IOException {
        InputStream inputStream = Pool.class.getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(inputStream);
        this.driverName = properties.getProperty("DriverClassName");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    // 装载和注册JDBC驱动程序
    private void loadDrivers(String driverName) {
        try {
            driver = (Driver) Class.forName(driverName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动程序" + driverName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("无法注册JDBC驱动程序" + driverName);
        }
    }

    // 单例模式，返回数据库连接池Pool的实例
    public static synchronized Pool getInstance() throws Exception {
        if (null == instance) {
            instance.init();
            instance = (Pool) Class.forName("com.ykq.factory02.refactorJdbcPool.pool.Pool").newInstance();
        }
        return instance;
    }

    // 创建连接池
    public abstract void createPool();

    // 获得一个可用的连接，如果没有则创建一个连接，且小于最大连接数
    public abstract Connection getConnection();

    // 获得一个可用的连接，有时间限制
    public abstract Connection getConnection(long time);

    // 将conn连接实例返回连接池
    public abstract void freeConnection(Connection conn);

    // 返回空闲连接数
    public abstract int getNum();

    // 返回当前使用的连接数
    public abstract int getNumActive();

    // 撤销驱动
    protected synchronized void release() {
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销JDBC驱动" + driver.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("无法撤销JDBC驱动" + driver.getClass().getName());
        }
    }
}
