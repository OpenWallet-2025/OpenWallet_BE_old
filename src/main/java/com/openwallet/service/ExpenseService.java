package com.openwallet.service;

import com.openwallet.domain.Expense;
import com.openwallet.dto.ExpenseRequest;
import com.openwallet.dto.ExpenseResponse;
import com.openwallet.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseResponse save(ExpenseRequest request) {
        Expense saved = expenseRepository.save(request.toEntity());

        return new ExpenseResponse(saved);
    }

    public List<ExpenseResponse> findAll() {
        return expenseRepository.findAll()
                .stream()
                .map(ExpenseResponse::new)
                .toList();
    }
}
