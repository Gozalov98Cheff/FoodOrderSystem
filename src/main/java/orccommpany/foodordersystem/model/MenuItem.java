package orccommpany.foodordersystem.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import orccommpany.foodordersystem.dto.OrderItemDto;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "menu_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    BigDecimal price;

    String category;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

}
