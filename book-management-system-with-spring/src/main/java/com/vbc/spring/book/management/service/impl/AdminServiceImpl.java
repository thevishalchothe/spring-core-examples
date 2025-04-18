package com.vbc.spring.book.management.service.impl;

import com.vbc.spring.book.management.repository.AdminRepository;
import com.vbc.spring.book.management.model.Admin;
import com.vbc.spring.book.management.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    // Setter-based dependency injection for AdminRepository
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void registerAdmin(Admin admin) {
        adminRepository.save(admin);  // Delegate to the repository to save the admin
    }

    @Override
    public Admin login(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);  // Delegate to repository to find admin
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();  // Delegate to repository to retrieve all admins
    }
}
