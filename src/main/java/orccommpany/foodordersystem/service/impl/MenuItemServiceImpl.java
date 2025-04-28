package orccommpany.foodordersystem.service.impl;

import lombok.RequiredArgsConstructor;
import orccommpany.foodordersystem.dto.MenuItemDto;
import orccommpany.foodordersystem.mapper.MenuItemMapper;
import orccommpany.foodordersystem.model.MenuItem;
import orccommpany.foodordersystem.repository.MenuItemRepository;
import orccommpany.foodordersystem.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MenuItemMapper menuItemMapper;

    @Override
    public MenuItemDto create(MenuItemDto dto) {
        MenuItem item = menuItemMapper.toEntity(dto);
        MenuItem saved = menuItemRepository.save(item);
        return menuItemMapper.toDto(saved);
    }

    @Override
    public MenuItemDto getById(Long id) {
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MenuItem not found"));
        return menuItemMapper.toDto(item);
    }

    @Override
    public List<MenuItemDto> getAll() {
        return menuItemRepository.findAll().stream()
                .map(menuItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuItemDto> getByCategory(String category) {
        return menuItemRepository.findByCategory(category).stream()
                .map(menuItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        menuItemRepository.deleteById(id);
    }

    @Override
    public MenuItemDto update(Long id, MenuItemDto dto) {
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MenuItem not found"));

        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setCategory(dto.getCategory());
        item.setPrice(dto.getPrice());

        MenuItem updated = menuItemRepository.save(item);
        return menuItemMapper.toDto(updated);
    }
}
