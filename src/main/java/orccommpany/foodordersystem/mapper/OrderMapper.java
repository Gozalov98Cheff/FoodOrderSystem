package orccommpany.foodordersystem.mapper;

import orccommpany.foodordersystem.dto.OrderDto;
import orccommpany.foodordersystem.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "totalAmount", ignore = true)
    Order toEntity(OrderDto dto);

    OrderDto toDto(Order order);
}

