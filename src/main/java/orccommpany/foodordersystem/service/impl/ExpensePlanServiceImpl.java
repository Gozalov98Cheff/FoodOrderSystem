package orccommpany.foodordersystem.service.impl;

import lombok.RequiredArgsConstructor;
import orccommpany.foodordersystem.dto.ExpensePlanDto;
import orccommpany.foodordersystem.model.ExpensePlan;
import orccommpany.foodordersystem.model.User;
import orccommpany.foodordersystem.repository.ExpensePlanRepository;
import orccommpany.foodordersystem.repository.UserRepository;
import orccommpany.foodordersystem.service.ExpensePlanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpensePlanServiceImpl implements ExpensePlanService {

    private final ExpensePlanRepository expensePlanRepository;
    private final UserRepository userRepository;

    @Override
    public ExpensePlanDto create(ExpensePlanDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ExpensePlan plan = new ExpensePlan();
        plan.setUser(user);
        plan.setCategory(dto.getCategory());
        plan.setPlannedAmount(dto.getPlannedAmount());
        plan.setTargetDate(dto.getTargetDate());

        ExpensePlan saved = expensePlanRepository.save(plan);

        ExpensePlanDto savedDto = new ExpensePlanDto();
        savedDto.setId(saved.getId());
        savedDto.setUserId(saved.getUser().getId());
        savedDto.setCategory(saved.getCategory());
        savedDto.setPlannedAmount(saved.getPlannedAmount());
        savedDto.setTargetDate(saved.getTargetDate());

        return savedDto;
    }

    @Override
    public List<ExpensePlanDto> getAll() {
        return expensePlanRepository.findAll().stream().map(plan -> {
            ExpensePlanDto dto = new ExpensePlanDto();
            dto.setId(plan.getId());
            dto.setUserId(plan.getUser().getId());
            dto.setCategory(plan.getCategory());
            dto.setPlannedAmount(plan.getPlannedAmount());
            dto.setTargetDate(plan.getTargetDate());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ExpensePlanDto getById(Long id) {
        ExpensePlan plan = expensePlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense Plan not found"));

        ExpensePlanDto dto = new ExpensePlanDto();
        dto.setId(plan.getId());
        dto.setUserId(plan.getUser().getId());
        dto.setCategory(plan.getCategory());
        dto.setPlannedAmount(plan.getPlannedAmount());
        dto.setTargetDate(plan.getTargetDate());

        return dto;
    }

    @Override
    public ExpensePlanDto update(Long id, ExpensePlanDto dto) {
        ExpensePlan plan = expensePlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense Plan not found"));

        plan.setCategory(dto.getCategory());
        plan.setPlannedAmount(dto.getPlannedAmount());
        plan.setTargetDate(dto.getTargetDate());

        ExpensePlan updated = expensePlanRepository.save(plan);

        ExpensePlanDto updatedDto = new ExpensePlanDto();
        updatedDto.setId(updated.getId());
        updatedDto.setUserId(updated.getUser().getId());
        updatedDto.setCategory(updated.getCategory());
        updatedDto.setPlannedAmount(updated.getPlannedAmount());
        updatedDto.setTargetDate(updated.getTargetDate());

        return updatedDto;
    }

    @Override
    public void delete(Long id) {
        expensePlanRepository.deleteById(id);
    }
}
