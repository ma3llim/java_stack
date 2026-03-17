package org.example.spring_to_spring_boot.repository;

import org.example.spring_to_spring_boot.models.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save(Laptop lap){
        System.out.println("Saved in Database...");
    }
}
