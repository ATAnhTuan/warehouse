package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.SystemConfigEntity;
import com.simsys.warehouse.requestdtos.SystemConfigRequestDto;
import com.simsys.warehouse.responsedto.SystemConfigResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class SystemConfigMapper {

    public static SystemConfigEntity toEntity(SystemConfigRequestDto dto) {
        if (dto == null) return null;
        return new SystemConfigEntity(dto.getName(), dto.getConfigValue(), dto.getDescription());
    }

    public static SystemConfigResponseDto toResponseDto(SystemConfigEntity entity) {
        if (entity == null) return null;
        return new SystemConfigResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getConfigValue(),
                entity.getDescription()
        );
    }

    public static List<SystemConfigResponseDto> toResponseDtoList(List<SystemConfigEntity> entities) {
        return entities.stream()
                .map(SystemConfigMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
