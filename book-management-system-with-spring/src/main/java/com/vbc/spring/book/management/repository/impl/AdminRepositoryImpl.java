package com.vbc.spring.book.management.repository.impl;

import com.vbc.spring.book.management.model.Admin;
import com.vbc.spring.book.management.repository.AdminRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    private DataSource dataSource;

    // Setter-based DI
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Admin admin) {
        String sql = "INSERT INTO admin (admin_name, username, password) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, admin.getAdminName());
            ps.setString(2, admin.getUsername());
            ps.setString(3, admin.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractAdminFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM admin";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                admins.add(extractAdminFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    public Admin findByName(String name) {
        String sql = "SELECT * FROM admin WHERE admin_name = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractAdminFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Admin extractAdminFromResultSet(ResultSet rs) throws SQLException {
        Admin admin = new Admin();
        admin.setId(rs.getInt("id"));
        admin.setAdminName(rs.getString("admin_name"));
        admin.setUsername(rs.getString("username"));
        admin.setPassword(rs.getString("password"));
        return admin;
    }
}
