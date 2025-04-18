package com.vbc.spring.book.management.repository;

import com.vbc.spring.book.management.model.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    List<User> findAll();

    User findById(int id);

    void update(int id, User user);

    void delete(int id);
}
