package orccommpany.foodordersystem.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemDto {
     Long menuItemId;
     int quantity;
     BigDecimal price;
}
