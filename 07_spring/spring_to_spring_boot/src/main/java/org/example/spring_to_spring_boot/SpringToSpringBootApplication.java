package org.example.spring_to_spring_boot;

import org.example.spring_to_spring_boot.models.Laptop;
import org.example.spring_to_spring_boot.services.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringToSpringBootApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringToSpringBootApplication.class, args);
        LaptopService service = context.getBean(LaptopService.class);
        Laptop lap = context.getBean(Laptop.class);
        service.addLaptop(lap);
    }

}
