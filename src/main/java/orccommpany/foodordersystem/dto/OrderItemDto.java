package orccommpany.foodordersystem.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long menuItemId;
    private int quantity;
    private double price;
}
