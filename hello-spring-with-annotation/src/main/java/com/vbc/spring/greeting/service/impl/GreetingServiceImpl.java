package com.vbc.spring.greeting.service.impl;

import com.vbc.spring.greeting.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String name) {
        return "Hello, " + name + "! (greeting from vishal..)";
    }
}