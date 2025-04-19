package com.vbc.spring.greeting;

import com.vbc.spring.greeting.config.AppConfig;
import com.vbc.spring.greeting.controller.GreetingController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingController controller = context.getBean(GreetingController.class);

        String greeting = controller.greet("Spring!");
        System.out.println(greeting);

    }
}