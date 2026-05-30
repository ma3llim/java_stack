package SchoolManagementSystem;

import java.util.Objects;

public class Student extends Person implements Gradable {
    private Grade grade;
    private String studentId;


    @Override
    public Grade getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", studentId='" + studentId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return  true;
        if(!(obj instanceof Student)) return false;
        if(!super.equals(obj)) return  false;
        Student student = (Student) obj;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode(){
        return  Objects.hash(super.hashCode(), studentId, grade);
    }
}
