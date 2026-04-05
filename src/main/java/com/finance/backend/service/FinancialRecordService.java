package com.finance.backend.service;

import com.finance.backend.entity.FinancialRecord;
import com.finance.backend.entity.RecordType;
import com.finance.backend.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository recordRepository;

    public FinancialRecord createRecord(FinancialRecord record) {
        return recordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    public List<FinancialRecord> getByType(RecordType type) {
        return recordRepository.findByType(type);
    }

    public List<FinancialRecord> getByCategory(String category) {
        return recordRepository.findByCategory(category);
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord updated) {
        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setAmount(updated.getAmount());
        record.setType(updated.getType());
        record.setCategory(updated.getCategory());
        record.setDate(updated.getDate());
        record.setDescription(updated.getDescription());

        return recordRepository.save(record);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}