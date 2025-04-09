package com.vbc.spring.example.main;

import com.vbc.spring.example.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        HelloService service = (HelloService) context.getBean("helloService");
        System.out.println(service.getMessage());
    }
}
