package com.finance.backend.controller;

import com.finance.backend.entity.FinancialRecord;
import com.finance.backend.entity.RecordType;
import com.finance.backend.service.FinancialRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService recordService;

    @PostMapping
    public FinancialRecord createRecord(@Valid @RequestBody FinancialRecord record) {
        return recordService.createRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getAllRecords() {
        return recordService.getAllRecords();
    }

    @GetMapping("/type/{type}")
    public List<FinancialRecord> getByType(@PathVariable RecordType type) {
        return recordService.getByType(type);
    }

    @GetMapping("/category/{category}")
    public List<FinancialRecord> getByCategory(@PathVariable String category) {
        return recordService.getByCategory(category);
    }

    @PutMapping("/{id}")
    public FinancialRecord updateRecord(@PathVariable Long id,
                                        @Valid @RequestBody FinancialRecord record) {
        return recordService.updateRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return "Record deleted successfully";
    }
}