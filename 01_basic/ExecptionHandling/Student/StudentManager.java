package ExecptionHandling.Student;

import ExecptionHandling.exceptions.DuplicateStudentException;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student) throws DuplicateStudentException {
        for(Student stud: students) {
            if (stud.getId() == student.getId()) {
                throw new DuplicateStudentException("Student Already Exists");
            }
        }
        students.add(student);
    }
}
