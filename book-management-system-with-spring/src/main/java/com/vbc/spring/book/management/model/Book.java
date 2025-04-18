package com.vbc.spring.book.management.model;

import lombok.Data;

@Data
public class Book {
    private int bid;
    private String title;
    private String author;
    private String genre;
    private int publishedYear;
    private User user;
}
