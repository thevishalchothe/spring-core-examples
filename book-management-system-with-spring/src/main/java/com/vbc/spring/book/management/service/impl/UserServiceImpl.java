package com.vbc.spring.book.management.service.impl;

import com.vbc.spring.book.management.model.User;
import com.vbc.spring.book.management.repository.UserRepository;
import com.vbc.spring.book.management.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(int id, User user) {
        userRepository.update(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }
}
