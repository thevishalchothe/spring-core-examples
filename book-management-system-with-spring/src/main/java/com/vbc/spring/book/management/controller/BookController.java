package com.vbc.spring.book.management.controller;

import com.vbc.spring.book.management.model.Book;
import com.vbc.spring.book.management.service.BookService;
import lombok.Setter;

import java.util.List;

@Setter
public class BookController {

    // Setter-based Dependency Injection
    private BookService bookService;

    // Add a new book
    public void addBook(Book book) {
        if (book != null) {
            bookService.addBook(book);
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Invalid book data. Book not added.");
        }
    }

    // View all books
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

    // Get book by ID
    public void getBookById(int bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
    }

    // Update book by ID
    public void updateBook(int bookId, Book updatedBook) {
        Book existingBook = bookService.getBookById(bookId);
        if (existingBook != null) {
            updatedBook.setBid(bookId);  // Make sure the bookId is set for the update
            bookService.updateBook(bookId, updatedBook); // Pass bookId and updated book
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
    }

    // Delete book by ID
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
