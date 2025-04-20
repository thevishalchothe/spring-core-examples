package com.vbc.library.management.controller;


import com.vbc.library.management.model.User;
import com.vbc.library.management.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Setter
public class UserController {

    @Autowired
    private UserService userService;

    public void addUser(User user) {
        userService.addUser(user);
        System.out.println("User added successfully!");
    }

    public void viewAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users != null && !users.isEmpty()) {
            System.out.println("\n--- List of Users ---");
            for (User u : users) {
                System.out.println(u);
            }
        } else {
            System.out.println("No users found.");
        }
    }

    public void getUserById(int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            System.out.println("User found: " + user);
        } else {
            System.out.println("User not found with ID: " + id);
        }
    }

    public void updateUser(int id, User updatedUser) {
        User existing = userService.getUserById(id);
        if (existing != null) {
            updatedUser.setUid(id);
            userService.updateUser(id, updatedUser);
            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found with ID: " + id);
        }
    }

    public void deleteUser(int id) {
        User existing = userService.getUserById(id);
        if (existing != null) {
            userService.deleteUser(id);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found with ID: " + id);
        }
    }
}
