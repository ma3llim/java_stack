package com.example.jdbc_h2.services;

import com.example.jdbc_h2.Repositories.StudentRepo;
import com.example.jdbc_h2.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s){
        repo.save(s);
    }


    public List<Student> getStudents() {
        return  repo.findAll();
    }
}
