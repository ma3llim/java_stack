package org.manytomany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Laptop {

    @Id
    @GeneratedValue
    private int id;

    private String brand;
    private String model;
    private String ram;
    private String storage;

    @ManyToMany(mappedBy = "laptops")

    private List<Students> students;

    public Laptop(List<Students> students) {
        this.students = students;
    }

    public Laptop(String brand, String model, String ram, String storage) {
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

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}