package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.ConsignmentEntity;
import com.simsys.warehouse.mapper.ConsignmentMapper;
import com.simsys.warehouse.repository.ConsignmentRepository;
import com.simsys.warehouse.requestdto.ConsignmentRequestDto;
import com.simsys.warehouse.responsedto.ConsignmentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ConsignmentService {

    @Autowired
    private ConsignmentRepository repository;

    public ConsignmentResponseDto create(ConsignmentRequestDto dto) {
        ConsignmentEntity entity = ConsignmentMapper.toEntity(dto);

        if (entity.getPayPrice() != null && entity.getQuantity() != null) {
            entity.setTotalPrice(entity.getPayPrice().multiply(BigDecimal.valueOf(entity.getQuantity())));
        } else {
            entity.setTotalPrice(BigDecimal.ZERO);
        }

        return ConsignmentMapper.toResponseDto(repository.save(entity));
    }

    public List<ConsignmentResponseDto> getAll() {
        return repository.findAll().stream()
                .map(ConsignmentMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public ConsignmentResponseDto getByGuid(UUID guid) {
        ConsignmentEntity entity = repository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Consignment not found with guid: " + guid));
        return ConsignmentMapper.toResponseDto(entity);
    }

    public void deleteByGuid(UUID guid) {
        repository.deleteByGuid(guid);
    }

    public ConsignmentResponseDto update(UUID guid, ConsignmentRequestDto dto) {
        ConsignmentEntity entity = repository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Consignment not found with guid: " + guid));

        entity.setSku(dto.getSku());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPayPrice(dto.getPayPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setSupplierGuid(dto.getSupplierGuid());
        entity.setPurchaseOrderGuid(dto.getPurchaseOrderGuid());

        if (entity.getPayPrice() != null && entity.getQuantity() != null) {
            entity.setTotalPrice(entity.getPayPrice().multiply(BigDecimal.valueOf(entity.getQuantity())));
        } else {
            entity.setTotalPrice(BigDecimal.ZERO);
        }

        return ConsignmentMapper.toResponseDto(repository.save(entity));
    }

    public List<ConsignmentResponseDto> findBySupplierGuid(UUID supplierGuid) {
        List<ConsignmentEntity> entities = repository.findAllBySupplierGuid(supplierGuid);
        return entities.stream()
                .map(ConsignmentMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
