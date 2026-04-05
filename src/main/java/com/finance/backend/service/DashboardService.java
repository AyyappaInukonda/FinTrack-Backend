package com.finance.backend.service;

import com.finance.backend.entity.RecordType;
import com.finance.backend.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DashboardService {

    @Autowired
    private FinancialRecordRepository recordRepository;

    public Map<String, Object> getSummary() {

        Double income = recordRepository.getTotalByType(RecordType.INCOME);
        Double expense = recordRepository.getTotalByType(RecordType.EXPENSE);

        // handle null (important real-world case)
        if (income == null) income = 0.0;
        if (expense == null) expense = 0.0;

        Double balance = income - expense;

        Map<String, Object> result = new HashMap<>();
        result.put("totalIncome", income);
        result.put("totalExpense", expense);
        result.put("netBalance", balance);

        return result;
    }

    public Map<String, Double> getCategoryData() {

        List<Object[]> data = recordRepository.getCategorySummary();
        Map<String, Double> result = new HashMap<>();

        for (Object[] row : data) {
            String category = (String) row[0];
            Double total = (Double) row[1];
            result.put(category, total);
        }

        return result;
    }
}