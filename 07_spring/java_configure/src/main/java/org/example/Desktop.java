package org.example;

public class Desktop implements Computer {

    public Desktop(){
        System.out.println("Object Created For Desktop");
    }

    @Override
    public void device(){
        System.out.println("Compiling Using Desktop");
    }
}
