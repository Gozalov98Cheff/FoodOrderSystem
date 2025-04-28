package orccommpany.foodordersystem.mapper;

import orccommpany.foodordersystem.dto.MenuItemDto;
import orccommpany.foodordersystem.model.MenuItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    MenuItemDto toDto(MenuItem item);

    MenuItem toEntity(MenuItemDto dto);
}
