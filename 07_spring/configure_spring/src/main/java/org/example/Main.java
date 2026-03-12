package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
        Student obj = (Student) context.getBean("student", Student.class);
        // Laptop obj2 = (Laptop) context.getBean("laptop");
        // obj.code();
        Desktop desktopObj = context.getBean(Desktop.class);

    }
}