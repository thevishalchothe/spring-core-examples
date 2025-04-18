package com.vbc.spring.book.management.service.impl;

import com.vbc.spring.book.management.model.Records;
import com.vbc.spring.book.management.repository.RecordsRepository;
import com.vbc.spring.book.management.service.RecordsService;

import java.util.List;

public class RecordsServiceImpl implements RecordsService {

    private RecordsRepository recordsRepository;

    public void setRecordsRepository(RecordsRepository recordsRepository) {
        this.recordsRepository = recordsRepository;
    }

    @Override
    public void borrowBook(Records record) {
        recordsRepository.saveRecord(record);
    }

    @Override
    public Records getRecord(int id) {
        return recordsRepository.getRecordById(id);
    }

    @Override
    public List<Records> getAllRecords() {
        return recordsRepository.getAllRecords();
    }

    @Override
    public void updateRecord(Records record) {
        recordsRepository.updateRecord(record);
    }

    @Override
    public void deleteRecord(int id) {
        recordsRepository.deleteRecord(id);
    }

    @Override
    public List<Records> getRecordsByUserName(String userName) {
        return recordsRepository.getRecordsByUserName(userName);
    }
}
