package org.example.spring_to_spring_boot.models;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {

    public Desktop(){
        System.out.println("Object Created For Desktop");
    }

    @Override
    public void device(){
        System.out.print("Compiling Using Desktop");
    }
}
