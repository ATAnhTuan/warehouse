package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.SupplierPerformanceEntity;
import com.simsys.warehouse.requestdto.SupplierPerformanceRequestDto;
import com.simsys.warehouse.responsedto.SupplierPerformanceResponseDto;

public class SupplierPerformanceMapper {

    public static SupplierPerformanceEntity toEntity(SupplierPerformanceRequestDto dto) {
        SupplierPerformanceEntity entity = new SupplierPerformanceEntity();
        entity.setSupplierGuid(dto.getSupplierGuid());
        entity.setConsignmentGuid(dto.getConsignmentGuid());
        entity.setUserGuid(dto.getUserGuid());
        entity.setOnTimeDeliveryRate(dto.getOnTimeDeliveryRate());
        entity.setProductQualityRating(dto.getProductQualityRating());
        entity.setSupplyCompletionRate(dto.getSupplyCompletionRate());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public static SupplierPerformanceResponseDto toResponseDto(SupplierPerformanceEntity entity) {
        SupplierPerformanceResponseDto dto = new SupplierPerformanceResponseDto();
        dto.setId(entity.getId());
        dto.setGuid(entity.getGuid());
        dto.setSupplierGuid(entity.getSupplierGuid());
        dto.setConsignmentGuid(entity.getConsignmentGuid());
        dto.setUserGuid(entity.getUserGuid());
        dto.setOnTimeDeliveryRate(entity.getOnTimeDeliveryRate());
        dto.setProductQualityRating(entity.getProductQualityRating());
        dto.setSupplyCompletionRate(entity.getSupplyCompletionRate());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
