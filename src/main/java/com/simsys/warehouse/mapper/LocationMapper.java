package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.LocationEntity;
import com.simsys.warehouse.requestdto.LocationRequestDto;
import com.simsys.warehouse.responsedto.LocationResponseDto;

public class LocationMapper {

    public static LocationEntity toEntity(LocationRequestDto dto) {
        return new LocationEntity(dto.getLocationName(), dto.getDescription(), dto.getInventoryGuid());
    }

    public static LocationResponseDto toResponseDto(LocationEntity entity) {
        return new LocationResponseDto(
                entity.getGuid(),
                entity.getLocationName(),
                entity.getDescription(),
                entity.getInventoryGuid()
        );
    }
}
