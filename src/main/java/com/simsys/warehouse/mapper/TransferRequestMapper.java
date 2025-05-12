package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.TransferRequestEntity;
import com.simsys.warehouse.requestdto.TransferRequestRequestDto;
import com.simsys.warehouse.responsedto.TransferRequestResponseDto;

public class TransferRequestMapper {

    public static TransferRequestEntity toEntity(TransferRequestRequestDto dto) {
        if (dto == null) return null;
        TransferRequestEntity entity = new TransferRequestEntity();
        entity.setFromInventoryGuid(dto.getFromInventoryGuid());
        entity.setToInventoryGuid(dto.getToInventoryGuid());
        entity.setUserGuid(dto.getUserGuid());
        entity.setProductGuid(dto.getProductGuid());
        entity.setQuantity(dto.getQuantity());
        entity.setNote(dto.getNote());
        return entity;
    }

    public static TransferRequestResponseDto toResponseDto(TransferRequestEntity entity) {
        if (entity == null) return null;
        return new TransferRequestResponseDto(
                entity.getGuid(),
                entity.getFromInventoryGuid(),
                entity.getToInventoryGuid(),
                entity.getUserGuid(),
                entity.getProductGuid(),
                entity.getQuantity(),
                entity.getCreateDate(),
                entity.getNote()
        );
    }
}
