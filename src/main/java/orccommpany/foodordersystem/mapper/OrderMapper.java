package orccommpany.foodordersystem.mapper;

import orccommpany.foodordersystem.dto.OrderDto;
import orccommpany.foodordersystem.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    Order toEntity(OrderDto dto);
}
