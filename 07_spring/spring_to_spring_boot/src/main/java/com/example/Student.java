package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Student {
    private String name;
    @Autowired
    private Computer com;

    public Student(){
        System.out.println("Object Created For Student");
    }
    @ConstructorProperties({"name", "lap"})
    public Student(String name, Laptop com) {
        this.name = name;
        this.com = com;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    @Qualifier("laptop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        com.device();
        System.out.println("Code");
    }
}
