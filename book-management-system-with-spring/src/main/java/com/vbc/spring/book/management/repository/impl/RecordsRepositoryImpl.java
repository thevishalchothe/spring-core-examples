package com.vbc.spring.book.management.repository.impl;

import com.vbc.spring.book.management.model.Book;
import com.vbc.spring.book.management.model.Records;
import com.vbc.spring.book.management.model.User;
import com.vbc.spring.book.management.repository.RecordsRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordsRepositoryImpl implements RecordsRepository {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void saveRecord(Records record) {
        String sql = "INSERT INTO records (uid, bid, borrow_date, return_date, is_returned) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, record.getUser().getUid());
            ps.setInt(2, record.getBook().getBid());
            ps.setString(3, record.getBorrowDate());
            ps.setString(4, record.getReturnDate());
            ps.setBoolean(5, record.isReturned());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Records getRecordById(int recordId) {
        String sql = "SELECT r.*, u.uname, b.title FROM records r " +
                "JOIN user u ON r.uid = u.uid " +
                "JOIN book b ON r.bid = b.bid " +
                "WHERE r.record_id = ?";
        Records record = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, recordId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    record = mapRow(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }

    @Override
    public List<Records> getAllRecords() {
        List<Records> recordsList = new ArrayList<>();
        String sql = "SELECT r.*, u.uname, b.title FROM records r " +
                "JOIN user u ON r.uid = u.uid " +
                "JOIN book b ON r.bid = b.bid";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                recordsList.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordsList;
    }

    @Override
    public void updateRecord(Records record) {
        String sql = "UPDATE records SET uid = ?, bid = ?, borrow_date = ?, return_date = ?, is_returned = ? WHERE record_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, record.getUser().getUid());
            ps.setInt(2, record.getBook().getBid());
            ps.setString(3, record.getBorrowDate());
            ps.setString(4, record.getReturnDate());
            ps.setBoolean(5, record.isReturned());
            ps.setInt(6, record.getRecordId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRecord(int recordId) {
        String sql = "DELETE FROM records WHERE record_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, recordId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Records> getRecordsByUserName(String userName) {
        List<Records> recordsList = new ArrayList<>();
        String sql = "SELECT r.*, u.uname, b.title FROM records r " +
                "JOIN user u ON r.uid = u.uid " +
                "JOIN book b ON r.bid = b.bid " +
                "WHERE u.uname = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    recordsList.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordsList;
    }

    private Records mapRow(ResultSet rs) throws SQLException {
        Records record = new Records();
        record.setRecordId(rs.getInt("record_id"));

        User user = new User();
        user.setUid(rs.getInt("uid"));
        user.setUname(rs.getString("uname"));
        record.setUser(user);

        Book book = new Book();
        book.setBid(rs.getInt("bid"));
        book.setTitle(rs.getString("title"));
        record.setBook(book);

        record.setBorrowDate(rs.getString("borrow_date"));
        record.setReturnDate(rs.getString("return_date"));
        record.setReturned(rs.getBoolean("is_returned"));

        return record;
    }
}
