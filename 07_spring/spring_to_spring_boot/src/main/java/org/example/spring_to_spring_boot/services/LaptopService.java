package org.example.spring_to_spring_boot.services;

import org.example.spring_to_spring_boot.models.Laptop;
import org.example.spring_to_spring_boot.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap){
        repo.save(lap);
    }

    public boolean isGoodForProg(Laptop lap){
        return true;
    }
}
