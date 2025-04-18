package com.vbc.spring.book.management.repository;

import com.vbc.spring.book.management.model.Book;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    List<Book> findAll();

    Book findById(int id);

    void update(int id, Book book);

    void delete(int id);
}
