package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.VariantEntity;
import com.simsys.warehouse.requestdto.VariantRequestDto;
import com.simsys.warehouse.responsedto.VariantResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class VariantMapper {

    public static VariantEntity toEntity(VariantRequestDto dto) {
        VariantEntity entity = new VariantEntity();
        entity.setColor(dto.getColor());
        entity.setSize(dto.getSize());
        return entity;
    }

    public static VariantResponseDto toResponseDto(VariantEntity entity) {
        return new VariantResponseDto(
                entity.getId(),
                entity.getGuid(),
                entity.getColor(),
                entity.getSize()
        );
    }

    public static List<VariantResponseDto> toResponseDtoList(List<VariantEntity> entities) {
        return entities.stream()
                .map(VariantMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
