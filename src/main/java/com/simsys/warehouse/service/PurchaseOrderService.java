package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.PurchaseOrderDetailEntity;
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

    public PurchaseOrderResponseDto update(UUID guid, PurchaseOrderRequestDto dto) {
        PurchaseOrderEntity existing = purchaseOrderRepository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found with GUID: " + guid));

        existing.setSupplierGuid(dto.getSupplierGuid());
        existing.setDescription(dto.getDescription());
        existing.setTotalPrice(dto.getTotalPrice());
        existing.setIsActive(dto.getIsActive());


        List<PurchaseOrderDetailEntity> updatedDetails = dto.getPurchaseOrderDetails().stream()
                .map(detailDto -> {
                    PurchaseOrderDetailEntity detailEntity = new PurchaseOrderDetailEntity();
                    detailEntity.setGuid(UUID.randomUUID());
                    detailEntity.setProductGuid(detailDto.getProductGuid());
                    detailEntity.setQuantity(detailDto.getQuantity());
                    detailEntity.setPurchaseOrderGuid(existing.getGuid());
                    return detailEntity;
                }).toList();

        existing.setPurchaseOrderDetails(updatedDetails);

        PurchaseOrderEntity saved = purchaseOrderRepository.save(existing);
        return PurchaseOrderMapper.toResponseDto(saved);
    }


}
