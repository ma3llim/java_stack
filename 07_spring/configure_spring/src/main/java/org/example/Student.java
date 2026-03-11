package org.example;

public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(){
        System.out.println("Object Created For Student");
    }

    public void code(){
        System.out.println("Code");
    }
}
