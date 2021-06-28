package com.ykq.base01.base3;

import com.ykq.base01.base.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JdbcTemplate
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/19
 * @Version v1.0.0
 */
public class JdbcTemplate {
    public static void update(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 2、获取数据库连接
            conn = JdbcUtil.getConnection();
            // 3、创建语句对象
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            // 4、执行sql语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);
        }
    }

    public static Student query(String sql, int id) {
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
            JdbcUtil.close(rs, ps, conn);
        }
        return null;
    }

    public static List<Student> list(String sql) {
        List<Student> list = new ArrayList<>();
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
            JdbcUtil.close(rs, ps, conn);
        }
        return list;
    }
}
