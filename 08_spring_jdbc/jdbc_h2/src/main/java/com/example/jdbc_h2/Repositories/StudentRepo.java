package com.example.jdbc_h2.Repositories;

import com.example.jdbc_h2.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student s){
        String sql = "insert into student (rollno, name, marks) values (?,?,?)";
        int rows = jdbcTemplate.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println(rows);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return  students;
    }
}
