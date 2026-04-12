package com.sameer.spring_data_jpa;

import com.sameer.spring_data_jpa.model.Student;
import com.sameer.spring_data_jpa.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setRollNo(1);
		s1.setName("Sameer");
		s1.setMarks(99);

		s2.setRollNo(2);
		s2.setName("John");
		s2.setMarks(94);

		s3.setRollNo(3);
		s3.setName("Jeevan");
		s3.setMarks(90);

		// repo.save(s1);
		// repo.save(s2);
		// repo.save(s3);

		// Find By Id
		// System.out.println(repo.findById(1));

		// Getting By Key Values
		// System.out.println(repo.findByName("Sameer"));

		// Update Query
			// Flow
				// 1. First It Call Select Query to check if then
				// 2. Then it will Call Update Query

		// repo.save(s1);

		// Delete Query
			// Flow
				// 1. First It Call Select Query to check if then
				// 2. Then it will Call Delete Query
		 repo.delete(s1);
	}

}
