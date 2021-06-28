package com.ykq.base01.base;

import java.sql.*;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/19
 * @Version v1.0.0
 */
public class StudentService {
    public void save(Student student) {
        String sql = "INSERT INTO student (name, age) values(?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1、加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://10.150.30.115:3306/l_salesman_191213", "ls_yanfa", "ls_yanfa");
            // 3、创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            // 4、执行sql语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (null != conn) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1、加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://10.150.30.115:3306/l_salesman_191213", "ls_yanfa", "ls_yanfa");
            // 3、创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            // 4、执行sql语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (null != conn) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1、加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://10.150.30.115:3306/l_salesman_191213", "ls_yanfa", "ls_yanfa");
            // 3、创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setInt(3, student.getId());
            // 4、执行sql语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (null != conn) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student = new Student("c", 3);
        studentService.save(student);
    }
}
