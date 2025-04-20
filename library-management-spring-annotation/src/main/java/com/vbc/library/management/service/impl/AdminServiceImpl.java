package com.vbc.library.management.service.impl;

import com.vbc.library.management.model.Admin;
import com.vbc.library.management.repository.AdminRepository;
import com.vbc.library.management.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

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