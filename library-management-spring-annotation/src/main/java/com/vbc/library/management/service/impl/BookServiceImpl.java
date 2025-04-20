package com.vbc.library.management.service.impl;


import com.vbc.library.management.model.Book;
import com.vbc.library.management.repository.BookRepository;
import com.vbc.library.management.service.BookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        bookRepository.update(id, book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.delete(id);
    }
}
