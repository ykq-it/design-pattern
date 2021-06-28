package com.ykq.factory02.refactorJdbcPool;

import com.ykq.base01.base.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Student
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/19
 * @Version v1.0.0
 */
public class StudentRowMapper implements IRowMapper {

    @Override
    public List<Student> mapping(ResultSet rs) throws Exception {
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
        }
        return list;
    }
}
