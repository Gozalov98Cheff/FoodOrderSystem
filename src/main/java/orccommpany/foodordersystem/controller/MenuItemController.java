package orccommpany.foodordersystem.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import orccommpany.foodordersystem.dto.MenuItemDto;
import orccommpany.foodordersystem.service.MenuItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping
    public MenuItemDto create(@RequestBody MenuItemDto dto) {
        return menuItemService.create(dto);
    }

    @GetMapping
    public List<MenuItemDto> getAll() {
        return menuItemService.getAll();
    }

    @GetMapping("/{id}")
    public MenuItemDto getById(@PathVariable Long id) {
        return menuItemService.getById(id);
    }

    @GetMapping("/category")
    public List<MenuItemDto> getByCategory(@RequestParam String category) {
        return menuItemService.getByCategory(category);
    }

    @PutMapping("/{id}")
    public MenuItemDto update(@PathVariable Long id, @RequestBody MenuItemDto dto) {
        return menuItemService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        menuItemService.delete(id);
    }
}

