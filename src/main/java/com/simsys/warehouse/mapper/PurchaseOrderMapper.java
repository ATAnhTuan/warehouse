package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.PurchaseOrderDetailEntity;
import com.simsys.warehouse.entity.PurchaseOrderEntity;
import com.simsys.warehouse.requestdto.PurchaseOrderRequestDto;
import com.simsys.warehouse.responsedto.PurchaseOrderDetailResponseDto;
import com.simsys.warehouse.responsedto.PurchaseOrderResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PurchaseOrderMapper {

    public static PurchaseOrderEntity toEntity(PurchaseOrderRequestDto dto) {
        PurchaseOrderEntity entity = new PurchaseOrderEntity();
        entity.setSupplierGuid(dto.getSupplierGuid());
        entity.setDescription(dto.getDescription());
        entity.setTotalPrice(dto.getTotalPrice());
        entity.setIsActive(dto.getIsActive());

        // Chuyển đổi PurchaseOrderDetailRequestDto thành PurchaseOrderDetailEntity
        List<PurchaseOrderDetailEntity> details = dto.getPurchaseOrderDetails().stream()
                .map(detailDto -> {
                    PurchaseOrderDetailEntity detailEntity = new PurchaseOrderDetailEntity();
                    detailEntity.setGuid(UUID.randomUUID());
                    detailEntity.setProductGuid(detailDto.getProductGuid());
                    detailEntity.setQuantity(detailDto.getQuantity());
                    detailEntity.setPurchaseOrderGuid(entity.getGuid());
                    return detailEntity;
                }).collect(Collectors.toList());

        entity.setPurchaseOrderDetails(details);
        return entity;
    }

    public static PurchaseOrderResponseDto toResponseDto(PurchaseOrderEntity entity) {
        List<PurchaseOrderDetailResponseDto> detailDtos = entity.getPurchaseOrderDetails().stream()
                .map(detail -> new PurchaseOrderDetailResponseDto(
                        detail.getGuid(),
                        detail.getProductGuid(),
                        detail.getQuantity()
                )).collect(Collectors.toList());

        return new PurchaseOrderResponseDto(
                entity.getGuid(),
                entity.getSupplierGuid(),
                entity.getDescription(),
                entity.getTotalPrice(),
                entity.getIsActive(),
                detailDtos
        );
    }
}
