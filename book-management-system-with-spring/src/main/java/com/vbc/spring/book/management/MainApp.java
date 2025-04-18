package com.vbc.spring.book.management;

import com.vbc.spring.book.management.controller.AdminController;
import com.vbc.spring.book.management.controller.BookController;
import com.vbc.spring.book.management.controller.UserController;
import com.vbc.spring.book.management.model.Admin;
import com.vbc.spring.book.management.model.Book;
import com.vbc.spring.book.management.model.College;
import com.vbc.spring.book.management.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        AdminController adminController = context.getBean("adminController", AdminController.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        UserController userController = context.getBean("userController", UserController.class);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
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
                    Admin admin = new Admin();
                    System.out.print("Admin Name: ");
                    admin.setAdminName(scanner.nextLine());
                    System.out.print("Username: ");
                    admin.setUsername(scanner.nextLine());
                    System.out.print("Password: ");
                    admin.setPassword(scanner.nextLine());
                    adminController.registerAdmin(admin);
                    break;

                case 2:
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();

                    if (adminController.login(username, password)) {
                        System.out.println("Login successful!");

                        boolean afterLogin = true;
                        while (afterLogin) {
                            System.out.println("\n1. Book Operations");
                            System.out.println("2. User Operations");
                            System.out.println("3. Logout");
                            System.out.print("Choose an option: ");
                            int postLoginChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (postLoginChoice) {
                                case 1:
                                    System.out.println("\n1. Add Book");
                                    System.out.println("2. View All Books");
                                    System.out.println("3. View Book by ID");
                                    System.out.println("4. Update Book");
                                    System.out.println("5. Delete Book");
                                    System.out.print("Choose Book Option: ");
                                    int bookOption = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (bookOption) {
                                        case 1:
                                            Book book = new Book();
                                            System.out.print("Title: ");
                                            book.setTitle(scanner.nextLine());
                                            System.out.print("Author: ");
                                            book.setAuthor(scanner.nextLine());
                                            System.out.print("Genre: ");
                                            book.setGenre(scanner.nextLine());
                                            System.out.print("Year: ");
                                            book.setPublishedYear(scanner.nextInt());
                                            scanner.nextLine();
                                            bookController.addBook(book);
                                            break;
                                        case 2:
                                            bookController.viewAllBooks();
                                            break;
                                        case 3:
                                            System.out.print("Enter Book ID: ");
                                            bookController.getBookById(scanner.nextInt());
                                            scanner.nextLine();
                                            break;
                                        case 4:
                                            System.out.print("Enter Book ID to Update: ");
                                            int bid = scanner.nextInt();
                                            scanner.nextLine();
                                            Book updateBook = new Book();
                                            System.out.print("New Title: ");
                                            updateBook.setTitle(scanner.nextLine());
                                            System.out.print("New Author: ");
                                            updateBook.setAuthor(scanner.nextLine());
                                            System.out.print("New Genre: ");
                                            updateBook.setGenre(scanner.nextLine());
                                            System.out.print("New Year: ");
                                            updateBook.setPublishedYear(scanner.nextInt());
                                            scanner.nextLine();
                                            bookController.updateBook(bid, updateBook);
                                            break;
                                        case 5:
                                            System.out.print("Enter Book ID to Delete: ");
                                            bookController.deleteBook(scanner.nextInt());
                                            scanner.nextLine();
                                            break;
                                    }
                                    break;

                                case 2:
                                    System.out.println("\n1. Add User");
                                    System.out.println("2. View All Users");
                                    System.out.println("3. View User by ID");
                                    System.out.println("4. Update User");
                                    System.out.println("5. Delete User");
                                    System.out.print("Choose User Option: ");
                                    int userOption = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (userOption) {
                                        case 1:
                                            User user = new User();
                                            System.out.print("Name: ");
                                            user.setUname(scanner.nextLine());
                                            System.out.print("Email: ");
                                            user.setEmail(scanner.nextLine());
                                            System.out.print("Mobile: ");
                                            user.setMobile(scanner.nextLine());
                                            System.out.print("Address: ");
                                            user.setAddress(scanner.nextLine());
                                            System.out.println("College (SIOM / SIMCA / SCOEP): ");
                                            user.setCollege(College.valueOf(scanner.nextLine().toUpperCase()));
                                            userController.addUser(user);
                                            break;
                                        case 2:
                                            userController.viewAllUsers();
                                            break;
                                        case 3:
                                            System.out.print("Enter User ID: ");
                                            userController.getUserById(scanner.nextInt());
                                            scanner.nextLine();
                                            break;
                                        case 4:
                                            System.out.print("Enter User ID to Update: ");
                                            int uid = scanner.nextInt();
                                            scanner.nextLine();
                                            User updatedUser = new User();
                                            System.out.print("New Name: ");
                                            updatedUser.setUname(scanner.nextLine());
                                            System.out.print("New Email: ");
                                            updatedUser.setEmail(scanner.nextLine());
                                            System.out.print("New Mobile: ");
                                            updatedUser.setMobile(scanner.nextLine());
                                            System.out.print("New Address: ");
                                            updatedUser.setAddress(scanner.nextLine());
                                            System.out.println("New College (SIOM / SIMCA / SCOEP): ");
                                            updatedUser.setCollege(College.valueOf(scanner.nextLine().toUpperCase()));
                                            userController.updateUser(uid, updatedUser);
                                            break;
                                        case 5:
                                            System.out.print("Enter User ID to Delete: ");
                                            userController.deleteUser(scanner.nextInt());
                                            scanner.nextLine();
                                            break;
                                    }
                                    break;

                                case 3:
                                    afterLogin = false;
                                    System.out.println("Logged out from admin session.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Login failed! Try again.");
                    }
                    break;

                case 3:
                    adminController.showAllAdmins();
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1-4.");
            }
        }

        scanner.close();
    }
}
