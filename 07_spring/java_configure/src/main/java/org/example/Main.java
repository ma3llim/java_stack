package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Desktop desktopObj = context.getBean(Desktop.class);
        desktopObj.device();

        Desktop desktopObj2 = context.getBean(Desktop.class);
        desktopObj2.device();
    }
}