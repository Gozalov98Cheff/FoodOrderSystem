package orccommpany.foodordersystem.repository;

import orccommpany.foodordersystem.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
