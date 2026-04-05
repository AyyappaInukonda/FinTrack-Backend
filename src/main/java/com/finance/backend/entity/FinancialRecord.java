package com.finance.backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "financial_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Double amount;

    @Enumerated(EnumType.STRING)
    private RecordType type;

    @NotBlank(message = "Category is required")
    private String category;

    private LocalDate date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}