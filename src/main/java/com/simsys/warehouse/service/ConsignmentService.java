package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.ConsignmentEntity;
import com.simsys.warehouse.mapper.ConsignmentMapper;
import com.simsys.warehouse.repository.ConsignmentRepository;
import com.simsys.warehouse.requestdto.ConsignmentRequestDto;
import com.simsys.warehouse.responsedto.ConsignmentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ConsignmentService {

    @Autowired
    private ConsignmentRepository repository;

    public ConsignmentResponseDto create(ConsignmentRequestDto dto) {
        ConsignmentEntity entity = ConsignmentMapper.toEntity(dto);
        return ConsignmentMapper.toResponseDto(repository.save(entity));
    }

    public List<ConsignmentResponseDto> getAll() {
        return repository.findAll().stream()
                .map(ConsignmentMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public ConsignmentResponseDto getByGuid(UUID guid) {
        ConsignmentEntity entity = repository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return ConsignmentMapper.toResponseDto(entity);
    }

    public void deleteByGuid(UUID guid) {
        repository.deleteByGuid(guid);
    }

    public ConsignmentResponseDto update(UUID guid, ConsignmentRequestDto dto) {
        ConsignmentEntity entity = repository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Not found"));

        entity.setSku(dto.getSku());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setSupplierGuid(dto.getSupplierGuid());
        entity.setPurchaseOrderGuid(dto.getPurchaseOrderGuid());

        return ConsignmentMapper.toResponseDto(repository.save(entity));
    }
}
