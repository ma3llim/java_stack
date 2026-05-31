package SchoolManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person implements Teachable {
    List<String> subjects;

    Teacher(int id, String name, int age){
        super(id, name, age);
        this.subjects = new ArrayList<>();
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public List<String> getSubject() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + this.getId() +                    // Add id from Person
                ", name='" + this.getName() + '\'' +      // Add name from Person
                ", age=" + this.getAge() +                // Add age from Person
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(subjects);
    }
}
