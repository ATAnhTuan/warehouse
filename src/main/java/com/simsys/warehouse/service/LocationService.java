package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.LocationEntity;
import com.simsys.warehouse.mapper.LocationMapper;
import com.simsys.warehouse.repository.LocationRepository;
import com.simsys.warehouse.requestdto.LocationRequestDto;
import com.simsys.warehouse.responsedto.LocationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationResponseDto create(LocationRequestDto dto) {
        LocationEntity entity = LocationMapper.toEntity(dto);
        LocationEntity saved = locationRepository.save(entity);
        return LocationMapper.toResponseDto(saved);
    }

    public Optional<LocationResponseDto> findByGuid(UUID guid) {
        return locationRepository.findByGuid(guid)
                .map(LocationMapper::toResponseDto);
    }

    public List<LocationResponseDto> findAll() {
        return locationRepository.findAll()
                .stream()
                .map(LocationMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public Optional<LocationResponseDto> update(UUID guid, LocationRequestDto dto) {
        return locationRepository.findByGuid(guid).map(existing -> {
            existing.setLocationName(dto.getLocationName());
            existing.setDescription(dto.getDescription());
            existing.setInventoryGuid(dto.getInventoryGuid());
            return LocationMapper.toResponseDto(locationRepository.save(existing));
        });
    }

    public boolean deleteByGuid(UUID guid) {
        return locationRepository.findByGuid(guid).map(entity -> {
            locationRepository.delete(entity);
            return true;
        }).orElse(false);
    }
}
