package orccommpany.foodordersystem.service;

import orccommpany.foodordersystem.dto.MenuItemDto;

import java.util.List;

public interface MenuItemService {
    MenuItemDto create(MenuItemDto dto);
    MenuItemDto getById(Long id);
    List<MenuItemDto> getAll();
    List<MenuItemDto> getByCategory(String category);
    void delete(Long id);
    MenuItemDto update(Long id, MenuItemDto dto);

}
