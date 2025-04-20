package com.vbc.spring.book.management.model;

import lombok.Data;

@Data
public class Admin {
    private int id;
    private String adminName;
    private String username;
    private String password;
}
