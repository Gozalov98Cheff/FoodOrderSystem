package orccommpany.foodordersystem.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expense_plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpensePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

     String category;
     BigDecimal plannedAmount;
     LocalDate targetDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
