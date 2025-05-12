package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.PurchaseOrderEntity;
import com.simsys.warehouse.mapper.PurchaseOrderMapper;
import com.simsys.warehouse.repository.PurchaseOrderRepository;
import com.simsys.warehouse.requestdto.PurchaseOrderRequestDto;
import com.simsys.warehouse.responsedto.PurchaseOrderResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    // Tạo mới PurchaseOrder
    public PurchaseOrderResponseDto create(PurchaseOrderRequestDto dto) {
        PurchaseOrderEntity entity = PurchaseOrderMapper.toEntity(dto);
        PurchaseOrderEntity saved = purchaseOrderRepository.save(entity);
        return PurchaseOrderMapper.toResponseDto(saved);
    }

    // Lấy tất cả PurchaseOrders
    public List<PurchaseOrderResponseDto> findAll() {
        return purchaseOrderRepository.findAll().stream()
                .map(PurchaseOrderMapper::toResponseDto)
                .toList();
    }

    // Lấy PurchaseOrder theo GUID
    public PurchaseOrderResponseDto findByGuid(UUID guid) {
        PurchaseOrderEntity entity = purchaseOrderRepository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found with GUID: " + guid));
        return PurchaseOrderMapper.toResponseDto(entity);
    }

    // Xóa PurchaseOrder theo GUID
    public void deleteByGuid(UUID guid) {
        PurchaseOrderEntity entity = purchaseOrderRepository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found with GUID: " + guid));
        purchaseOrderRepository.delete(entity);
    }
}
