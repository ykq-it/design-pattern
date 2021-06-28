package com.ykq.base01.base5;

import com.ykq.base01.base.Student;

import java.sql.ResultSet;
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
        JdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge()});
    }

    public void delete(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        JdbcTemplate.update(sql, id);
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";
        JdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge(), student.getId()});
    }

    public Student get(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        List<Student> list = (List<Student>) JdbcTemplate.query(sql, new StudentRowMapper(), id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Student> list() {
        String sql = "SELECT * FROM student";
        return (List<Student>) JdbcTemplate.query(sql, new StudentRowMapper());
    }

    public Long getCount() {
        String sql = "SELECT COUNT(1) total FROM student";
        Long totalCount = JdbcTemplate.query(sql, new IRowMapper<Long>() {
            @Override
            public Long mapping(ResultSet rs) throws Exception {
                Long totalCount = null;
                if (rs.next()) {
                    totalCount = rs.getLong("total");
                }
                return totalCount;
            }
        });
        return totalCount;
    }

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student = new Student("c", 3);
        System.out.println(studentService.list());
        System.out.println(studentService.getCount());
    }
}
