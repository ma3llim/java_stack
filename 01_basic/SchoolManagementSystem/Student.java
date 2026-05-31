package SchoolManagementSystem;

import java.util.Objects;

public class Student extends Person implements Gradable {
    private final Grade grade;

    Student(int id, String name, int age, Grade grade){
        super(id, name, age);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(grade);
    }

    @Override
    public Grade getGrade() {
        return grade;
    }
}
