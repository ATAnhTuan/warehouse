package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.ConsignmentRequestDto;
import com.simsys.warehouse.responsedto.ConsignmentResponseDto;
import com.simsys.warehouse.service.ConsignmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/consignments")
@Tag(name = "Consignment")
public class ConsignmentController {

    @Autowired
    private ConsignmentService service;

    @PostMapping
    public ConsignmentResponseDto create(@RequestBody ConsignmentRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ConsignmentResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{guid}")
    public ConsignmentResponseDto getByGuid(@PathVariable UUID guid) {
        return service.getByGuid(guid);
    }

    @PutMapping("/{guid}")
    public ConsignmentResponseDto update(@PathVariable UUID guid, @RequestBody ConsignmentRequestDto dto) {
        return service.update(guid, dto);
    }

    @DeleteMapping("/{guid}")
    public void delete(@PathVariable UUID guid) {
        service.deleteByGuid(guid);
    }
}
