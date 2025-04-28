package orccommpany.foodordersystem.mapper;

import orccommpany.foodordersystem.dto.OrderItemDto;
import orccommpany.foodordersystem.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto toDto(OrderItem item);
    OrderItem toEntity(OrderItemDto dto);
}

