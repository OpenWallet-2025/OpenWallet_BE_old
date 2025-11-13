package com.openwallet.controller;

import com.openwallet.dto.ExpenseRequest;
import com.openwallet.dto.ExpenseResponse;
import com.openwallet.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<ExpenseResponse> create(@Valid @RequestBody ExpenseRequest request) {
        ExpenseResponse saved = expenseService.save(request);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<ExpenseResponse> getAll() {
        return expenseService.findAll();
    }
}
