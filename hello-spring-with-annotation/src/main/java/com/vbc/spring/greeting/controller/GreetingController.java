package com.vbc.spring.greeting.controller;


import com.vbc.spring.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    public String greet(String name) {
        return greetingService.greet(name);
    }
}