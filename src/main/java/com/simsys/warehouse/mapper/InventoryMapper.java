package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.InventoryEntity;
import com.simsys.warehouse.requestdto.InventoryRequestDto;
import com.simsys.warehouse.responsedto.InventoryResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryMapper {

    public static InventoryEntity toEntity(InventoryRequestDto dto) {
        if (dto == null) return null;
        return new InventoryEntity(
                dto.getName(),
                dto.getDescription(),
                dto.getQuantity(),
                dto.getUserGuid()
        );
    }

    public static InventoryResponseDto toResponseDto(InventoryEntity entity) {
        if (entity == null) return null;
        return new InventoryResponseDto(
                entity.getId(),
                entity.getGuid(),
                entity.getName(),
                entity.getDescription(),
                entity.getQuantity(),
                entity.getUserGuid()
        );
    }

    public static List<InventoryResponseDto> toResponseDtoList(List<InventoryEntity> entities) {
        return entities.stream()
                .map(InventoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
