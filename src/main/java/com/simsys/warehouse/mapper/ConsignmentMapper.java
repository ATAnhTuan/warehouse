package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.ConsignmentEntity;
import com.simsys.warehouse.requestdto.ConsignmentRequestDto;
import com.simsys.warehouse.responsedto.ConsignmentResponseDto;

public class ConsignmentMapper {

    public static ConsignmentEntity toEntity(ConsignmentRequestDto dto) {
        ConsignmentEntity entity = new ConsignmentEntity();
        entity.setSku(dto.getSku());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setSupplierGuid(dto.getSupplierGuid());
        entity.setPurchaseOrderGuid(dto.getPurchaseOrderGuid());
        return entity;
    }

    public static ConsignmentResponseDto toResponseDto(ConsignmentEntity entity) {
        ConsignmentResponseDto dto = new ConsignmentResponseDto();
        dto.setId(entity.getId());
        dto.setGuid(entity.getGuid());
        dto.setSku(entity.getSku());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setCreateDate(entity.getCreateDate());
        dto.setSupplierGuid(entity.getSupplierGuid());
        dto.setPurchaseOrderGuid(entity.getPurchaseOrderGuid());
        return dto;
    }
}
