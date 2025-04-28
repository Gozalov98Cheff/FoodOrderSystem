package orccommpany.foodordersystem.service;

import orccommpany.foodordersystem.dto.ExpensePlanDto;
import java.util.List;

public interface ExpensePlanService {

    ExpensePlanDto create(ExpensePlanDto dto);

    List<ExpensePlanDto> getAll();

    ExpensePlanDto getById(Long id);

    ExpensePlanDto update(Long id, ExpensePlanDto dto);

    void delete(Long id);
}

