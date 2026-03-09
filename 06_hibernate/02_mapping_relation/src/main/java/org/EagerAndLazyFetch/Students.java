package org.EagerAndLazyFetch;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Students {

    @Id
    @Column(name = "id")
    private int rollNo;

    @Column(name = "name")
    private String studentName;

    @Column(name = "marks")
    private int studentMarks;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Laptop> laptop;

    public Students() {
    }

    public Students(int rollNo, String studentName, int studentMarks, List<Laptop> laptop) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
        this.laptop = laptop;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(int studentMarks) {
        this.studentMarks = studentMarks;
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Students{" +
                "rollNo=" + rollNo +
                ", studentName='" + studentName + '\'' +
                ", studentMarks=" + studentMarks +
                ", laptop=" + laptop +
                '}';
    }
}