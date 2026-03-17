package org.example.spring_to_spring_boot.models;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    public Laptop(){
        System.out.println("Object Created For Laptop");
    }

    @Override
    public void device() {
        System.out.println("Compling With Laptop");
    }
}
