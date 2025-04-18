package com.vbc.spring.book.management.repository;

import com.vbc.spring.book.management.model.Records;
import java.util.List;

public interface RecordsRepository {

    void saveRecord(Records record);

    Records getRecordById(int recordId);

    List<Records> getAllRecords();

    void updateRecord(Records record);

    void deleteRecord(int recordId);

    List<Records> getRecordsByUserName(String userName);
}
