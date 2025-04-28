package orccommpany.foodordersystem.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import orccommpany.foodordersystem.dto.ExpensePlanDto;
import orccommpany.foodordersystem.service.ExpensePlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ExpensePlanController {

    private final ExpensePlanService expensePlanService;

    @PostMapping
    public ExpensePlanDto create(@RequestBody ExpensePlanDto dto) {
        return expensePlanService.create(dto);
    }

    @GetMapping
    public List<ExpensePlanDto> getAll() {
        return expensePlanService.getAll();
    }

    @GetMapping("/{id}")
    public ExpensePlanDto getById(@PathVariable Long id) {
        return expensePlanService.getById(id);
    }

    @PutMapping("/{id}")
    public ExpensePlanDto update(@PathVariable Long id, @RequestBody ExpensePlanDto dto) {
        return expensePlanService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        expensePlanService.delete(id);
    }
}

