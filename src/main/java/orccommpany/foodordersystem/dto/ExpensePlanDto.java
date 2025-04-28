package orccommpany.foodordersystem.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpensePlanDto {
    private Long id;
    private Long userId;
    private String category;
    private double plannedAmount;
    private LocalDate targetDate;
}
