package org.onetomany;

import jakarta.persistence.*;

@Entity
public class Laptop {

    @Id
    private int id;

    private String brand;
    private String model;
    private String ram;
    private String storage;

    @ManyToOne
    @JoinColumn(name = "students_id")
    private Students students;

    public Laptop() {
    }

    public Laptop(int id, String brand, String model, String ram, String storage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }
}