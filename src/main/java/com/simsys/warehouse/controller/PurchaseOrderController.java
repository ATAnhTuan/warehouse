package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.PurchaseOrderRequestDto;
import com.simsys.warehouse.responsedto.PurchaseOrderResponseDto;
import com.simsys.warehouse.service.PurchaseOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/purchase-orders")
@Tag(name = "Purchase Orders")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    // Tạo mới PurchaseOrder
    @PostMapping
    public ResponseEntity<PurchaseOrderResponseDto> create(@RequestBody PurchaseOrderRequestDto dto) {
        PurchaseOrderResponseDto response = purchaseOrderService.create(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Lấy tất cả PurchaseOrders
    @GetMapping
    public ResponseEntity<List<PurchaseOrderResponseDto>> findAll() {
        List<PurchaseOrderResponseDto> responseList = purchaseOrderService.findAll();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    // Lấy PurchaseOrder theo GUID
    @GetMapping("/{guid}")
    public ResponseEntity<PurchaseOrderResponseDto> findByGuid(@PathVariable UUID guid) {
        PurchaseOrderResponseDto response = purchaseOrderService.findByGuid(guid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Xóa PurchaseOrder theo GUID
    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteByGuid(@PathVariable UUID guid) {
        purchaseOrderService.deleteByGuid(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
