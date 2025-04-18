package com.vbc.spring.book.management.controller;

import com.vbc.spring.book.management.model.Admin;
import com.vbc.spring.book.management.service.AdminService;

import java.util.List;

public class AdminController {

    private AdminService adminService;

    // Setter-based dependency injection
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    // Register an Admin
    public void registerAdmin(Admin admin) {
        adminService.registerAdmin(admin);
        System.out.println("Admin registered successfully!");
    }

    // Login an Admin by username and password
    public void login(String username, String password) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            System.out.println("Logged in Admin: " + admin);
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    // Show all registered Admins
    public void showAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        if (admins.isEmpty()) {
            System.out.println("No admins found.");
        } else {
            for (Admin a : admins) {
                System.out.println(a);
            }
        }
    }
}
