package com.vbc.spring.book.management.repository;

import com.vbc.spring.book.management.model.Admin;

import java.util.List;

public interface AdminRepository {

    void save(Admin admin);

    Admin findByUsernameAndPassword(String username, String password);

    List<Admin> findAll();
}
