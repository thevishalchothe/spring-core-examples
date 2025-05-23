package com.vbc.spring.book.management.service.impl;

import com.vbc.spring.book.management.model.Admin;
import com.vbc.spring.book.management.repository.AdminRepository;
import com.vbc.spring.book.management.service.AdminService;
import lombok.Setter;

import java.util.List;

@Setter
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    @Override
    public void registerAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public Admin login(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminByName(String name) {
        return adminRepository.findByName(name);
    }
}
