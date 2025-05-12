package com.simsys.warehouse.controller;

import com.simsys.warehouse.entity.TransactionEntity;
import com.simsys.warehouse.mapper.TransactionMapper;
import com.simsys.warehouse.requestdto.TransactionRequestDto;
import com.simsys.warehouse.responsedto.TransactionResponseDto;
import com.simsys.warehouse.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDto> create(@RequestBody TransactionRequestDto dto) {
        TransactionEntity transaction = transactionService.create(dto);
        return ResponseEntity.ok(TransactionMapper.toResponseDto(transaction));
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDto>> findAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDto> findById(@PathVariable Long id) {
        return transactionService.findById(id)
                .map(TransactionMapper::toResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponseDto> update(@PathVariable Long id, @RequestBody TransactionRequestDto dto) {
        return transactionService.update(id, dto)
                .map(TransactionMapper::toResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return transactionService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
