package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.TransferRequestEntity;
import com.simsys.warehouse.mapper.TransferRequestMapper;
import com.simsys.warehouse.repository.TransferRequestRepository;
import com.simsys.warehouse.requestdto.TransferRequestRequestDto;
import com.simsys.warehouse.responsedto.TransferRequestResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransferRequestService {

    private final TransferRequestRepository repository;

    public TransferRequestService(TransferRequestRepository repository) {
        this.repository = repository;
    }

    public TransferRequestResponseDto create(TransferRequestRequestDto dto) {
        TransferRequestEntity entity = TransferRequestMapper.toEntity(dto);
        TransferRequestEntity savedEntity = repository.save(entity);
        return TransferRequestMapper.toResponseDto(savedEntity);
    }

    public List<TransferRequestResponseDto> getAll() {
        return repository.findAll().stream()
                .map(TransferRequestMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public TransferRequestResponseDto getByGuid(UUID guid) {
        TransferRequestEntity entity = repository.findByGuid(guid);
        if (entity == null) {
            throw new RuntimeException("Transfer request not found");
        }
        return TransferRequestMapper.toResponseDto(entity);
    }

    public TransferRequestResponseDto update(UUID guid, TransferRequestRequestDto dto) {
        TransferRequestEntity entity = repository.findByGuid(guid);
        if (entity == null) {
            throw new RuntimeException("Transfer request not found");
        }

        // Update fields
        entity.setFromInventoryGuid(dto.getFromInventoryGuid());
        entity.setToInventoryGuid(dto.getToInventoryGuid());
        entity.setUserGuid(dto.getUserGuid());
        entity.setProductGuid(dto.getProductGuid());
        entity.setQuantity(dto.getQuantity());
        entity.setNote(dto.getNote());

        TransferRequestEntity updatedEntity = repository.save(entity);
        return TransferRequestMapper.toResponseDto(updatedEntity);
    }

    public void delete(UUID guid) {
        TransferRequestEntity entity = repository.findByGuid(guid);
        if (entity != null) {
            repository.delete(entity);
        } else {
            throw new RuntimeException("Transfer request not found");
        }
    }
}
