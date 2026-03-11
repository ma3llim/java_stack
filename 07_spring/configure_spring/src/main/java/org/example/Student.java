package org.example;

public class Student {
    private String name;
    private Laptop lap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(){
        System.out.println("Object Created For Student");
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
