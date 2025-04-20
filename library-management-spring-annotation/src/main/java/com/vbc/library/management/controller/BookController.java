package com.vbc.library.management.controller;


import com.vbc.library.management.model.Book;
import com.vbc.library.management.service.BookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void addBook(Book book) {
        if (book != null) {
            bookService.addBook(book);
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Invalid book data. Book not added.");
        }
    }

    public void viewAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books != null && !books.isEmpty()) {
            System.out.println("\n--- List of Books ---");
            for (Book b : books) {
                System.out.println(b);
            }
        } else {
            System.out.println("No books found.");
        }
    }

    public void getBookById(int bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
    }

    public void updateBook(int bookId, Book updatedBook) {
        Book existingBook = bookService.getBookById(bookId);
        if (existingBook != null) {
            updatedBook.setBid(bookId);
            bookService.updateBook(bookId, updatedBook);
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
    }

    public void deleteBook(int bookId) {
        Book existingBook = bookService.getBookById(bookId);
        if (existingBook != null) {
            bookService.deleteBook(bookId);
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
    }
}
