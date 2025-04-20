package com.vbc.library.management.service.impl;


import com.vbc.library.management.model.Records;
import com.vbc.library.management.repository.RecordsRepository;
import com.vbc.library.management.service.RecordsService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsServiceImpl implements RecordsService {

    @Autowired
    private RecordsRepository recordsRepository;

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
