package org.example.config;
import org.example.Desktop;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public Desktop desktop(){
        return  new Desktop();
    }
}