package com.sameer.spring_data_jpa.repo;

import com.sameer.spring_data_jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    // @Query("select s from Student s where s.name = ?1") -- This is created by the JPA
    List<Student>findByName(String name);
    List<Student>findByMarks(int marks);
    List<Student>findByRollNo(int roll);
    List<Student>findByMarksGreaterThan(int roll);
}
