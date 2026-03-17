package com.example;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("prototype")
public class Desktop implements Computer {

    public Desktop(){
        System.out.println("Object Created For Desktop");
    }

    @Override
    public void device(){
        System.out.println("Compiling Using Desktop");
    }
}
