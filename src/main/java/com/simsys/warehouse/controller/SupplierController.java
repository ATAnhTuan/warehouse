package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.SupplierRequestDto;
import com.simsys.warehouse.responsedto.SupplierResponseDto;
import com.simsys.warehouse.service.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public SupplierResponseDto create(@RequestBody SupplierRequestDto dto) {
        return supplierService.create(dto);
    }

    @GetMapping
    public List<SupplierResponseDto> getAll() {
        return supplierService.getAll();
    }

    @GetMapping("/{guid}")
    public SupplierResponseDto getByGuid(@PathVariable UUID guid) {
        return supplierService.getByGuid(guid);
    }

    @PutMapping("/{guid}")
    public SupplierResponseDto update(@PathVariable UUID guid, @RequestBody SupplierRequestDto dto) {
        return supplierService.update(guid, dto);
    }

    @DeleteMapping("/{guid}")
    public void delete(@PathVariable UUID guid) {
        supplierService.delete(guid);
    }
}
