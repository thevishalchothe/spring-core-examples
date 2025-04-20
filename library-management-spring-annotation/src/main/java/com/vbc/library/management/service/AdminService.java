package com.vbc.library.management.service;

import com.vbc.library.management.model.Admin;
import java.util.List;

public interface AdminService {
    void registerAdmin(Admin admin);
    Admin login(String username, String password);
    List<Admin> getAllAdmins();
    Admin getAdminByName(String name);
}