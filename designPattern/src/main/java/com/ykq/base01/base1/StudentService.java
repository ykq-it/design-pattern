package com.ykq.base01.base1;

import com.ykq.base01.base.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            // 2、获取数据库连接
            conn = JdbcUtil.getConnection();
            // 3、创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            // 4、执行sql语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 2、获取数据库连接
            conn = JdbcUtil.getConnection();
            // 3、创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            // 4、执行sql语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);
        }
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 2、获取数据库连接
            conn = JdbcUtil.getConnection();
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
            JdbcUtil.close(null, ps, conn);
        }
    }

    public Student get(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 2、获取数据库连接
            conn = JdbcUtil.getConnection();
            // 3、创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            // 4、执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);
        }
        return null;
    }

    public List<Student> list() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 2、获取数据库连接
            conn = JdbcUtil.getConnection();
            // 3、创建语句对象
            ps = conn.prepareStatement(sql);
            // 4、执行sql语句
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);
        }
        return list;
    }

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student = new Student("c", 3);
        System.out.println(studentService.list());
    }
}
