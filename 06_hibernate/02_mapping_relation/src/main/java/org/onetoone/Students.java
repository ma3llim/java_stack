package org.onetoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Students {

    @Id
    @Column(name = "id")
    private int rollNo;
    @Column(name = "name")
    private String studentName;
    @Column(name = "marks")
    private int studentMarks;

    @OneToOne
    private Laptop laptop;

    public Students(int rollNo, String studentName, int studentMarks, Laptop laptop) {
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

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
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