package com.vbc.spring.book.management;

import com.vbc.spring.book.management.controller.AdminController;
import com.vbc.spring.book.management.model.Admin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Get the AdminController bean
        AdminController adminController = context.getBean("adminController", AdminController.class);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            // Display Management System options
            System.out.println("\n--- Admin Management System ---");
            System.out.println("1. Register Admin");
            System.out.println("2. Login Admin");
            System.out.println("3. Show All Admins");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Register Admin
                    System.out.print("Enter Admin Name: ");
                    String adminName = scanner.nextLine();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();

                    Admin admin = new Admin();
                    admin.setAdminName(adminName);
                    admin.setUsername(username);
                    admin.setPassword(password);

                    adminController.registerAdmin(admin);
                    break;

                case 2:
                    // Login Admin
                    System.out.print("Enter Username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.nextLine();

                    adminController.login(loginUsername, loginPassword);
                    break;

                case 3:
                    // Show All Admins
                    adminController.showAllAdmins();
                    break;

                case 4:
                    // Exit the application
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid option, please choose between 1 and 4.");
                    break;
            }
        }
    }
}
