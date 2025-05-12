package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.SupplierPerformanceEntity;
import com.simsys.warehouse.mapper.SupplierPerformanceMapper;
import com.simsys.warehouse.repository.SupplierPerformanceRepository;
import com.simsys.warehouse.requestdto.SupplierPerformanceRequestDto;
import com.simsys.warehouse.responsedto.SupplierPerformanceResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SupplierPerformanceService {

    private final SupplierPerformanceRepository repository;

    public SupplierPerformanceService(SupplierPerformanceRepository repository) {
        this.repository = repository;
    }

    public SupplierPerformanceResponseDto create(SupplierPerformanceRequestDto dto) {
        SupplierPerformanceEntity entity = SupplierPerformanceMapper.toEntity(dto);
        return SupplierPerformanceMapper.toResponseDto(repository.save(entity));
    }

    public List<SupplierPerformanceResponseDto> getAll() {
        return repository.findAll().stream()
                .map(SupplierPerformanceMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public SupplierPerformanceResponseDto getByGuid(UUID guid) {
        SupplierPerformanceEntity entity = repository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("SupplierPerformance not found"));
        return SupplierPerformanceMapper.toResponseDto(entity);
    }

    public void deleteByGuid(UUID guid) {
        repository.deleteByGuid(guid);
    }

    public SupplierPerformanceResponseDto update(UUID guid, SupplierPerformanceRequestDto dto) {
        SupplierPerformanceEntity entity = repository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("SupplierPerformance not found"));

        entity.setSupplierGuid(dto.getSupplierGuid());
        entity.setConsignmentGuid(dto.getConsignmentGuid());
        entity.setUserGuid(dto.getUserGuid());
        entity.setOnTimeDeliveryRate(dto.getOnTimeDeliveryRate());
        entity.setProductQualityRating(dto.getProductQualityRating());
        entity.setSupplyCompletionRate(dto.getSupplyCompletionRate());
        entity.setDescription(dto.getDescription());

        return SupplierPerformanceMapper.toResponseDto(repository.save(entity));
    }
}
