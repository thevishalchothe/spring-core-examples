package com.vbc.spring.book.management.controller;

import com.vbc.spring.book.management.model.Admin;
import com.vbc.spring.book.management.service.AdminService;

import java.util.List;

public class AdminController {

    private AdminService adminService;

    // Setter-based DI
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public void registerAdmin(Admin admin) {
        adminService.registerAdmin(admin);
        System.out.println("Admin registered successfully!");
    }

    public boolean login(String username, String password) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            System.out.println("Logged in Admin: " + admin);
            return true;
        } else {
            System.out.println("Invalid credentials!");
            return false;
        }
    }

    public void showAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        if (admins.isEmpty()) {
            System.out.println("No admins found.");
        } else {
            System.out.println("\n--- List of Admins ---");
            for (Admin admin : admins) {
                System.out.println(admin);
            }
        }
    }

    public void viewAdminDetails(String name) {
        Admin admin = adminService.getAdminByName(name);
        if (admin != null) {
            System.out.println("\nAdmin Details:\n" + admin);
        } else {
            System.out.println("Admin not found with name: " + name);
        }
    }
}
