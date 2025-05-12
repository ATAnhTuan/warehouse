package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.SupplierPerformanceRequestDto;
import com.simsys.warehouse.responsedto.SupplierPerformanceResponseDto;
import com.simsys.warehouse.service.SupplierPerformanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/supplier-performances")
@Tag(name = "Supplier Performances")
public class SupplierPerformanceController {

    private final SupplierPerformanceService service;

    public SupplierPerformanceController(SupplierPerformanceService service) {
        this.service = service;
    }

    @PostMapping
    public SupplierPerformanceResponseDto create(@RequestBody SupplierPerformanceRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<SupplierPerformanceResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{guid}")
    public SupplierPerformanceResponseDto getByGuid(@PathVariable UUID guid) {
        return service.getByGuid(guid);
    }

    @PutMapping("/{guid}")
    public SupplierPerformanceResponseDto update(@PathVariable UUID guid, @RequestBody SupplierPerformanceRequestDto dto) {
        return service.update(guid, dto);
    }

    @DeleteMapping("/{guid}")
    public void delete(@PathVariable UUID guid) {
        service.deleteByGuid(guid);
    }
}
