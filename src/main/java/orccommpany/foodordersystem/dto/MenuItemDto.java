package orccommpany.foodordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
}

