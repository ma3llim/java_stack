package org.example;

import java.beans.ConstructorProperties;

public class Student {
    private String name;
    private Laptop lap;

    public Student(){
        System.out.println("Object Created For Student");
    }
    @ConstructorProperties({"name", "lap"})
    public Student(String name, Laptop lap) {
        this.name = name;
        this.lap = lap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    public void code(){
        lap.device();
        System.out.println("Code");
    }
}
