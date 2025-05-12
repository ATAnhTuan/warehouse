package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.InventoryEntity;
import com.simsys.warehouse.mapper.InventoryMapper;
import com.simsys.warehouse.repository.InventoryRepository;
import com.simsys.warehouse.requestdto.InventoryRequestDto;
import com.simsys.warehouse.responsedto.InventoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryResponseDto create(InventoryRequestDto dto) {
        InventoryEntity entity = InventoryMapper.toEntity(dto);
        InventoryEntity saved = inventoryRepository.save(entity);
        return InventoryMapper.toResponseDto(saved);
    }

    public List<InventoryResponseDto> findAll() {
        return inventoryRepository.findAll().stream()
                .map(InventoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public Optional<InventoryResponseDto> findByGuid(UUID guid) {
        return inventoryRepository.findByGuid(guid)
                .map(InventoryMapper::toResponseDto);
    }

    public Optional<InventoryResponseDto> updateByGuid(UUID guid, InventoryRequestDto dto) {
        return inventoryRepository.findByGuid(guid)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setDescription(dto.getDescription());
                    existing.setQuantity(dto.getQuantity());
                    existing.setUserGuid(dto.getUserGuid());
                    InventoryEntity updated = inventoryRepository.save(existing);
                    return InventoryMapper.toResponseDto(updated);
                });
    }

    public boolean deleteByGuid(UUID guid) {
        return inventoryRepository.findByGuid(guid)
                .map(entity -> {
                    inventoryRepository.delete(entity);
                    return true;
                }).orElse(false);
    }

    public List<InventoryResponseDto> findByUserGuid(UUID userGuid) {
        return inventoryRepository.findByUserGuid(userGuid).stream()
                .map(InventoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
