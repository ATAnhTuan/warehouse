package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.SuggestPurchaseOrderRequestDto;
import com.simsys.warehouse.responsedto.SuggestPurchaseOrderResponseDto;
import com.simsys.warehouse.service.SuggestPurchaseOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggest-orders")
@Tag(name = "Suggest Orders")
public class SuggestPurchaseOrderController {

    private final SuggestPurchaseOrderService suggestPurchaseOrderService;

    public SuggestPurchaseOrderController(SuggestPurchaseOrderService suggestPurchaseOrderService) {
        this.suggestPurchaseOrderService = suggestPurchaseOrderService;
    }

    @PostMapping
    public ResponseEntity<SuggestPurchaseOrderResponseDto> create(@RequestBody SuggestPurchaseOrderRequestDto dto) {
        SuggestPurchaseOrderResponseDto created = suggestPurchaseOrderService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<SuggestPurchaseOrderResponseDto>> findAll() {
        return ResponseEntity.ok(suggestPurchaseOrderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuggestPurchaseOrderResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(suggestPurchaseOrderService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        suggestPurchaseOrderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
