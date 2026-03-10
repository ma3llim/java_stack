package com.example.basic_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BasicSpringApplication.class, args);
		Alien obj = context.getBean(Alien.class);

		obj.code();
	}

}
