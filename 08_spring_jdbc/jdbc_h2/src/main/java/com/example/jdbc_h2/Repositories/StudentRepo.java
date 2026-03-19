package com.example.jdbc_h2.Repositories;

import com.example.jdbc_h2.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    public void save(Student s){
       System.out.println(s);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return  students;
    }
}
