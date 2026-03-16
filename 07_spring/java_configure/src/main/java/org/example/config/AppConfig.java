package org.example.config;
import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.example.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class AppConfig {

    @Bean()
    public Student student(Computer com){
        Student obj = new Student();
        obj.setName("Mohd Sameer");
        obj.setCom(com);
        return obj;
    }

    @Bean()
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean
    @Primary
    public Laptop laptop(){
        return new Laptop();
    }
}