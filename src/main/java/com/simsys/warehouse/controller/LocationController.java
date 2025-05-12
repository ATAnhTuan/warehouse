package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.LocationRequestDto;
import com.simsys.warehouse.responsedto.LocationResponseDto;
import com.simsys.warehouse.service.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/locations")
@Tag(name = "Location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationResponseDto> create(@RequestBody LocationRequestDto dto) {
        return ResponseEntity.ok(locationService.create(dto));
    }

    @GetMapping("/{guid}")
    public ResponseEntity<LocationResponseDto> getByGuid(@PathVariable UUID guid) {
        return locationService.findByGuid(guid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LocationResponseDto>> getAll() {
        return ResponseEntity.ok(locationService.findAll());
    }

    @PutMapping("/{guid}")
    public ResponseEntity<LocationResponseDto> update(@PathVariable UUID guid, @RequestBody LocationRequestDto dto) {
        return locationService.update(guid, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> delete(@PathVariable UUID guid) {
        if (locationService.deleteByGuid(guid)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
