package com.vbc.library.management;


import com.vbc.library.management.config.AppConfig;
import com.vbc.library.management.controller.AdminController;
import com.vbc.library.management.controller.BookController;
import com.vbc.library.management.controller.RecordsController;
import com.vbc.library.management.controller.UserController;
import com.vbc.library.management.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        // Use AnnotationConfigApplicationContext to load the context based on annotation-based configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the controllers from the application context
        AdminController adminController = context.getBean(AdminController.class);
        BookController bookController = context.getBean(BookController.class);
        UserController userController = context.getBean(UserController.class);
        RecordsController recordsController = context.getBean(RecordsController.class);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library Book Management System ---");
            System.out.println("1. Register as Admin");
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
                            System.out.println("3. Record Operations");
                            System.out.println("4. Logout");
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
                                    System.out.println("\n1. Add Record");
                                    System.out.println("2. View All Records");
                                    System.out.println("3. View Record by ID");
                                    System.out.println("4. Update Record");
                                    System.out.println("5. Delete Record");
                                    System.out.println("6. View Records by User");
                                    System.out.print("Choose Record Option: ");
                                    int recOpt = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (recOpt) {
                                        case 1:
                                            Records record = new Records();
                                            System.out.print("User ID: ");
                                            User rUser = new User();
                                            rUser.setUid(scanner.nextInt());
                                            scanner.nextLine();
                                            record.setUser(rUser);
                                            System.out.print("Book ID: ");
                                            Book rBook = new Book();
                                            rBook.setBid(scanner.nextInt());
                                            scanner.nextLine();
                                            record.setBook(rBook);
                                            System.out.print("Borrow Date (YYYY-MM-DD): ");
                                            record.setBorrowDate(scanner.nextLine());
                                            System.out.print("Return Date (YYYY-MM-DD): ");
                                            record.setReturnDate(scanner.nextLine());
                                            System.out.print("Is Returned (true/false): ");
                                            record.setReturned(scanner.nextBoolean());
                                            scanner.nextLine();
                                            recordsController.borrowBook(record);
                                            break;
                                        case 2:
                                            recordsController.viewAllRecords();
                                            break;
                                        case 3:
                                            System.out.print("Enter Record ID: ");
                                            recordsController.getRecordById(scanner.nextInt());
                                            scanner.nextLine();
                                            break;
                                        case 4:
                                            System.out.print("Enter Record ID to Update: ");
                                            int rid = scanner.nextInt();
                                            scanner.nextLine();
                                            Records updateRec = new Records();
                                            System.out.print("New User ID: ");
                                            User u = new User();
                                            u.setUid(scanner.nextInt());
                                            scanner.nextLine();
                                            updateRec.setUser(u);
                                            System.out.print("New Book ID: ");
                                            Book b = new Book();
                                            b.setBid(scanner.nextInt());
                                            scanner.nextLine();
                                            updateRec.setBook(b);
                                            System.out.print("New Borrow Date: ");
                                            updateRec.setBorrowDate(scanner.nextLine());
                                            System.out.print("New Return Date: ");
                                            updateRec.setReturnDate(scanner.nextLine());
                                            System.out.print("Is Returned: ");
                                            updateRec.setReturned(scanner.nextBoolean());
                                            scanner.nextLine();
                                            recordsController.updateRecord(rid, updateRec);
                                            break;
                                        case 5:
                                            System.out.print("Enter Record ID to Delete: ");
                                            recordsController.deleteRecord(scanner.nextInt());
                                            scanner.nextLine();
                                            break;
                                        case 6:
                                            System.out.print("Enter User Name to View Records: ");
                                            String userName = scanner.nextLine();
                                            recordsController.getRecordsByUserName(userName);
                                            break;
                                    }
                                    break;

                                case 4:
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
    }
}
