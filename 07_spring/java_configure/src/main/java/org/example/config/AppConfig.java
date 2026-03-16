package org.example.config;
import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.example.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("org.example")
public class AppConfig {
}