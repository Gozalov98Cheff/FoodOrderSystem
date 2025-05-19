package orccommpany.foodordersystem.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
     Long id;
     Long userId;
     LocalDateTime orderDate;
     String status;
     BigDecimal totalAmount;
     List<OrderItemDto> items;
}

