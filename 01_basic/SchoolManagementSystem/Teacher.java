package SchoolManagementSystem;

import java.util.List;
import java.util.Objects;

public class Teacher extends Person implements Teachable{
    private String employeeId;
    private String hireDate;
    private double salary;
    private List<String> subjects;

    @Override
    public List<String> getSubjects(){
        return subjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "employeeId='" + employeeId + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", salary=" + salary +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Double.compare(salary, teacher.salary) == 0 && Objects.equals(employeeId, teacher.employeeId) && Objects.equals(hireDate, teacher.hireDate) && Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeId, hireDate, salary, subjects);
    }
}
