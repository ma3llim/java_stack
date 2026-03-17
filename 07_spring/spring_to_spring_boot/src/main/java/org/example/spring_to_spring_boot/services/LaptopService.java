package org.example.spring_to_spring_boot.services;

import org.example.spring_to_spring_boot.models.Laptop;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    public void addLaptop(Laptop lap){
        System.out.println("Method Called");
    }

    public boolean isGoodForProg(Laptop lap){
        return true;
    }
}
