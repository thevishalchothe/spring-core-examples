package com.vbc.spring.book.management;

import com.vbc.spring.book.management.controller.AdminController;
import com.vbc.spring.book.management.controller.BookController;
import com.vbc.spring.book.management.model.Admin;
import com.vbc.spring.book.management.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        AdminController adminController = context.getBean("adminController", AdminController.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Admin Management System ---");
            System.out.println("1. Register Admin");
            System.out.println("2. Login Admin");
            System.out.println("3. Show All Admins");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Admin Name: ");
                    String adminName = scanner.nextLine();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();

                    Admin newAdmin = new Admin();
                    newAdmin.setAdminName(adminName);
                    newAdmin.setUsername(username);
                    newAdmin.setPassword(password);

                    adminController.registerAdmin(newAdmin);
                    break;

                case 2:
                    System.out.print("Enter Username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.nextLine();

                    boolean isLoggedIn = adminController.login(loginUsername, loginPassword);
                    if (isLoggedIn) {
                        System.out.println("Login successful!");

                        boolean adminExit = false;
                        while (!adminExit) {
                            System.out.println("\n--- Book Management ---");
                            System.out.println("1. Add Book");
                            System.out.println("2. View All Books");
                            System.out.println("3. View Book by ID");
                            System.out.println("4. Update Book");
                            System.out.println("5. Delete Book");
                            System.out.println("6. View Admin Details");
                            System.out.println("7. Logout");
                            System.out.print("Choose an option (1-7): ");
                            int adminChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (adminChoice) {
                                case 1:
                                    Book book = new Book();
                                    System.out.print("Enter Book Title: ");
                                    book.setTitle(scanner.nextLine());
                                    System.out.print("Enter Author: ");
                                    book.setAuthor(scanner.nextLine());
                                    System.out.print("Enter Genre: ");
                                    book.setGenre(scanner.nextLine());
                                    System.out.print("Enter Published Year: ");
                                    book.setPublishedYear(scanner.nextInt());
                                    scanner.nextLine();

                                    bookController.addBook(book);
                                    break;

                                case 2:
                                    bookController.viewAllBooks();
                                    break;

                                case 3:
                                    System.out.print("Enter Book ID to view: ");
                                    int viewId = scanner.nextInt();
                                    scanner.nextLine();
                                    bookController.getBookById(viewId);
                                    break;

                                case 4:
                                    System.out.print("Enter Book ID to update: ");
                                    int updateId = scanner.nextInt();
                                    scanner.nextLine();

                                    Book updatedBook = new Book();
                                    System.out.print("Enter New Title: ");
                                    updatedBook.setTitle(scanner.nextLine());
                                    System.out.print("Enter New Author: ");
                                    updatedBook.setAuthor(scanner.nextLine());
                                    System.out.print("Enter New Genre: ");
                                    updatedBook.setGenre(scanner.nextLine());
                                    System.out.print("Enter New Published Year: ");
                                    updatedBook.setPublishedYear(scanner.nextInt());
                                    scanner.nextLine();

                                    bookController.updateBook(updateId, updatedBook);
                                    break;

                                case 5:
                                    System.out.print("Enter Book ID to delete: ");
                                    int deleteId = scanner.nextInt();
                                    scanner.nextLine();
                                    bookController.deleteBook(deleteId);
                                    break;

                                case 6:
                                    System.out.print("Enter Admin Name to view details: ");
                                    String nameToSearch = scanner.nextLine();
                                    adminController.viewAdminDetails(nameToSearch);
                                    break;

                                case 7:
                                    adminExit = true;
                                    System.out.println("Logged out from admin panel.");
                                    break;

                                default:
                                    System.out.println("Invalid option. Choose 1 to 7.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Login failed!");
                    }
                    break;

                case 3:
                    adminController.showAllAdmins();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid option. Choose 1 to 4.");
            }
        }

        scanner.close();
    }
}
