package SchoolManagementSystem;

import java.util.List;

public class School {
    private String name;
    private String address;
    private List<Student> studentList;
    private List<Teacher> teacherList;

    School(String name, String address, List<Student> studentList, List<Teacher> teacherList){
        this.name = name;
        this.address = address;
        this.studentList = studentList;
        this.teacherList = teacherList;
    }

    void addStudent(Student student){
        studentList.add(student);
    }

    void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }
}
