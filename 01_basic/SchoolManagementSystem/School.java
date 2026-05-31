package SchoolManagementSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School {
    private String name;
    private String address;
    private List<Student> studentList;
    private List<Teacher> teacherList;

    School(String name, String address){
        this.name = name;
        this.address = address;
        this.studentList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
    }

    void addStudent(Student student){
        studentList.add(student);
    }

     List<Student> allStudents(){
        return new ArrayList<>(studentList);
    }

    Student searchByNameStudent(String name){
        for(Student student: studentList){
            if(student.getName().equalsIgnoreCase(name)){
                return student;
            }
        }
        return null;
    }

    void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }

    List<Teacher> allTeacher(){
        return new ArrayList<>(teacherList);
    }

    Teacher searchByNameTeacher(String name){
        for(Teacher teacher : teacherList){
            if(teacher.getName().equalsIgnoreCase(name)){
                return teacher;
            }
        }
        return null;
    }

    List<Student> getTopStudents(){
        List<Student> studentsTopList = null;

        for(Student student : studentList){
            if(student.getGrade() == Grade.A_PLUS){
                studentsTopList.add(student);
            }
        }
        return null;
    }

    public static void main(String[] args){
        School school = new School("ABC HIGH SCHOOL", "Hyderabad");

        Student s1 = new Student(1, "Rahul", 16, Grade.A_PLUS);
        Student s2 = new Student(2, "Priya", 15, Grade.A);
        Student s3 = new Student(3, "Amit", 17, Grade.B_PLUS);

        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);

        Teacher t1 = new Teacher(101, "Mr. Sharma", 35);
        t1.setSubjects(Arrays.asList("Mathematics", "Physics"));

        Teacher t2 = new Teacher(102, "Ms. Patel", 40);
        t2.setSubjects(Arrays.asList("English", "Social"));

        school.addTeacher(t1);
        school.addTeacher(t2);

        System.out.println("=== SCHOOL INFO ===");
        System.out.println("School: " + school.name);
        System.out.println("Address: " + school.address);
        System.out.println();
        System.out.println("=== TEACHER INFO ===");
        System.out.println(school.allTeacher());
        System.out.println("=== Student INFO ===");
        System.out.println(school.allStudents());
    }
}
