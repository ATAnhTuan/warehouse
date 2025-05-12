package com.simsys.warehouse.controller;

import com.simsys.warehouse.entity.SystemConfigEntity;
import com.simsys.warehouse.mapper.SystemConfigMapper;
import com.simsys.warehouse.requestdtos.SystemConfigRequestDto;
import com.simsys.warehouse.responsedto.SystemConfigResponseDto;
import com.simsys.warehouse.service.SystemConfigService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system-configs")
@Tag(name = "System Config")
public class SystemConfigController {

    private final SystemConfigService service;

    public SystemConfigController(SystemConfigService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SystemConfigResponseDto> create(@RequestBody SystemConfigRequestDto dto) {
        SystemConfigEntity config = service.create(dto);
        return ResponseEntity.ok(SystemConfigMapper.toResponseDto(config));
    }

    @GetMapping
    public ResponseEntity<List<SystemConfigResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemConfigResponseDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SystemConfigResponseDto> update(@PathVariable Long id, @RequestBody SystemConfigRequestDto dto) {
        return service.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
