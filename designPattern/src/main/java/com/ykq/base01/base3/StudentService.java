package com.ykq.base01.base3;

import com.ykq.base01.base.Student;

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
        return JdbcTemplate.query(sql, id);
    }

    public List<Student> list() {
        String sql = "SELECT * FROM student";
        return JdbcTemplate.list(sql);
    }

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student = new Student("c", 3);
        System.out.println(studentService.list());
    }
}
