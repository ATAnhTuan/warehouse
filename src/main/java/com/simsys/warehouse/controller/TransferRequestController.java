package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.TransferRequestRequestDto;
import com.simsys.warehouse.responsedto.TransferRequestResponseDto;
import com.simsys.warehouse.service.TransferRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transfer-requests")
@Tag(name = "Transfer Requests")
public class TransferRequestController {

    private final TransferRequestService service;

    public TransferRequestController(TransferRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TransferRequestResponseDto> create(@RequestBody TransferRequestRequestDto dto) {
        TransferRequestResponseDto response = service.create(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransferRequestResponseDto>> getAll() {
        List<TransferRequestResponseDto> responses = service.getAll();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{guid}")
    public ResponseEntity<TransferRequestResponseDto> getByGuid(@PathVariable UUID guid) {
        TransferRequestResponseDto response = service.getByGuid(guid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<TransferRequestResponseDto> update(@PathVariable UUID guid, @RequestBody TransferRequestRequestDto dto) {
        TransferRequestResponseDto response = service.update(guid, dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> delete(@PathVariable UUID guid) {
        service.delete(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
