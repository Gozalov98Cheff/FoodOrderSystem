package orccommpany.foodordersystem.service;

import orccommpany.foodordersystem.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto placeOrder(OrderDto orderDto);
    List<OrderDto> getUserOrders(Long userId);
    OrderDto getOrderById(Long orderId);
    List<OrderDto> getAllOrders();
    OrderDto updateOrderStatus(Long id, String status);

}
