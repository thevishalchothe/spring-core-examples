package com.vbc.spring.book.management.service.impl;

import com.vbc.spring.book.management.model.Book;
import com.vbc.spring.book.management.repository.BookRepository;
import com.vbc.spring.book.management.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    // Setter for DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
        // Update the book using the provided bookId (id) and new book details
        bookRepository.update(id, book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.delete(id);
    }
}
