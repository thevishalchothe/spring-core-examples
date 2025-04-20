package com.vbc.spring.book.management.controller;

import com.vbc.spring.book.management.model.Records;
import com.vbc.spring.book.management.service.RecordsService;
import lombok.Setter;

import java.util.List;

@Setter
public class RecordsController {

    private RecordsService recordsService;

    public void borrowBook(Records record) {
        recordsService.borrowBook(record);
        System.out.println("Book borrowed successfully.");
    }

    public void viewAllRecords() {
        List<Records> records = recordsService.getAllRecords();
        if (records.isEmpty()) {
            System.out.println("No records found.");
        } else {
            records.forEach(System.out::println);
        }
    }

    public void getRecordById(int id) {
        Records record = recordsService.getRecord(id);
        System.out.println(record != null ? record : "No record found with ID: " + id);
    }

    public void updateRecord(int rid, Records record) {
        recordsService.updateRecord(record);
        System.out.println("Record updated successfully.");
    }

    public void deleteRecord(int id) {
        recordsService.deleteRecord(id);
        System.out.println("Record deleted successfully.");
    }

    public void getRecordsByUserName(String userName) {
        List<Records> records = recordsService.getRecordsByUserName(userName);
        if (records.isEmpty()) {
            System.out.println("No records found for user: " + userName);
        } else {
            records.forEach(System.out::println);
        }
    }
}
