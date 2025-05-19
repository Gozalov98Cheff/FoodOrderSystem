package orccommpany.foodordersystem.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpensePlanDto {
     Long id;
     Long userId;
     String category;
     BigDecimal plannedAmount;
     LocalDate targetDate;
}
