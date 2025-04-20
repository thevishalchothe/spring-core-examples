package com.vbc.library.management.service;

import com.vbc.library.management.model.Records;

import java.util.List;

public interface RecordsService {

    void borrowBook(Records record);

    Records getRecord(int id);

    List<Records> getAllRecords();

    void updateRecord(Records record);

    void deleteRecord(int id);

    List<Records> getRecordsByUserName(String userName);
}
