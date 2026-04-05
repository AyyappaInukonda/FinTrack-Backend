package com.finance.backend.repository;

import com.finance.backend.entity.FinancialRecord;
import com.finance.backend.entity.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(RecordType type);

    List<FinancialRecord> findByCategory(String category);

    @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = :type")
    Double getTotalByType(@Param("type") RecordType type);

    @Query("SELECT f.category, SUM(f.amount) FROM FinancialRecord f GROUP BY f.category")
    List<Object[]> getCategorySummary();
}