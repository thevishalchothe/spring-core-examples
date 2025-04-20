package com.vbc.library.management.service.impl;

import com.vbc.library.management.model.User;
import com.vbc.library.management.repository.UserRepository;
import com.vbc.library.management.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
