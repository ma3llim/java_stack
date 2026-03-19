package com.example.jdbc_h2;

import com.example.jdbc_h2.models.Student;
import com.example.jdbc_h2.services.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JdbcH2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcH2Application.class, args);

		Student studentobj = context.getBean(Student.class);
		studentobj.setRollNo(1);
		studentobj.setName("Mohd Sameer");
		studentobj.setMarks(69);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(studentobj);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
