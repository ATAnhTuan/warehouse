package com.simsys.warehouse.controller;

import com.simsys.warehouse.entity.VariantEntity;
import com.simsys.warehouse.mapper.VariantMapper;
import com.simsys.warehouse.requestdto.VariantRequestDto;
import com.simsys.warehouse.responsedto.VariantResponseDto;
import com.simsys.warehouse.service.VariantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/variants")
@Tag(name = "Variant")
public class VariantController {

    private final VariantService variantService;

    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @PostMapping
    public ResponseEntity<VariantResponseDto> create(@RequestBody VariantRequestDto dto) {
        VariantEntity variant = variantService.create(dto);
        return ResponseEntity.ok(VariantMapper.toResponseDto(variant));
    }

    @GetMapping
    public ResponseEntity<List<VariantResponseDto>> findAll() {
        return ResponseEntity.ok(variantService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VariantResponseDto> findById(@PathVariable Long id) {
        return variantService.findById(id)
                .map(VariantMapper::toResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VariantResponseDto> update(@PathVariable Long id, @RequestBody VariantRequestDto dto) {
        return variantService.update(id, dto)
                .map(VariantMapper::toResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return variantService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
