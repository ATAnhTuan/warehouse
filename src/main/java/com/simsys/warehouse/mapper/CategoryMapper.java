package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.CategoryEntity;
import com.simsys.warehouse.requestdto.CategoryRequestDto;
import com.simsys.warehouse.responsedto.CategoryResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryEntity toEntity(CategoryRequestDto dto) {
        if (dto == null) return null;
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public static CategoryResponseDto toResponseDto(CategoryEntity entity) {
        if (entity == null) return null;
        return new CategoryResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getGuid()
        );
    }

    public static List<CategoryResponseDto> toResponseDtoList(List<CategoryEntity> entities) {
        return entities.stream()
                .map(CategoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
