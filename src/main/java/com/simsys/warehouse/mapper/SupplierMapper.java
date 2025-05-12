package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.requestdto.SupplierRequestDto;
import com.simsys.warehouse.responsedto.SupplierResponseDto;

public class SupplierMapper {

    public static SupplierEntity toEntity(SupplierRequestDto dto) {
        SupplierEntity entity = new SupplierEntity();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setIsActive(dto.getIsActive());
        return entity;
    }

    public static SupplierResponseDto toResponseDto(SupplierEntity entity) {
        return new SupplierResponseDto(
                entity.getId(),
                entity.getGuid(),
                entity.getName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getIsActive()
        );
    }
}
