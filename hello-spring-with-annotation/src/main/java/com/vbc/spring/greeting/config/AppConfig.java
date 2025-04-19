package com.vbc.spring.greeting.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.vbc.spring.greeting")
public class AppConfig {
    // Component scanning will find both @Service and @Controller components
}