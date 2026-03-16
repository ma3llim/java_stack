package org.example.config;
import org.example.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class AppConfig {

    @Bean()
    @Scope(value ="prototype")
    public Desktop desktop(){
        return  new Desktop();
    }
}