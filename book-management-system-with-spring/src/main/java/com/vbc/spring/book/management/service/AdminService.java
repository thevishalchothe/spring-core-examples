package com.vbc.spring.book.management.service;

import com.vbc.spring.book.management.model.Admin;

import java.util.List;

public interface AdminService {

    void registerAdmin(Admin admin);

    Admin login(String username, String password);

    List<Admin> getAllAdmins();

    Admin getAdminByName(String name);
}
