package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.InventoryRequestDto;
import com.simsys.warehouse.responsedto.InventoryResponseDto;
import com.simsys.warehouse.service.InventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/inventories")
@Tag(name = "Inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<InventoryResponseDto> create(@RequestBody InventoryRequestDto dto) {
        return ResponseEntity.ok(inventoryService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<InventoryResponseDto>> findAll() {
        return ResponseEntity.ok(inventoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponseDto> getByGuid(@PathVariable UUID guid) {
        Optional<InventoryResponseDto> response = inventoryService.findByGuid(guid);
        return response.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryResponseDto> updateByGuid(@PathVariable UUID guid, @RequestBody InventoryRequestDto dto) {
        Optional<InventoryResponseDto> response = inventoryService.updateByGuid(guid, dto);
        return response.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID guid) {
        boolean deleted = inventoryService.deleteByGuid(guid);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userGuid}")
    public ResponseEntity<List<InventoryResponseDto>> findByUserGuid(@PathVariable UUID userGuid) {
        return ResponseEntity.ok(inventoryService.findByUserGuid(userGuid));
    }
}
