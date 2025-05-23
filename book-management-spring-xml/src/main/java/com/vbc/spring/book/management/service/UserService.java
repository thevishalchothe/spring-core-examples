package com.vbc.spring.book.management.service;

import com.vbc.spring.book.management.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
