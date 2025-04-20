package com.vbc.library.management.repository;

import com.vbc.library.management.model.Admin;
import java.util.List;

public interface AdminRepository {
    void save(Admin admin);
    Admin findByUsernameAndPassword(String username, String password);
    List<Admin> findAll();
    Admin findByName(String name);
}