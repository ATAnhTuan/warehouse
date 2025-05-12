package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.mapper.SupplierMapper;
import com.simsys.warehouse.repository.SupplierRepository;
import com.simsys.warehouse.requestdto.SupplierRequestDto;
import com.simsys.warehouse.responsedto.SupplierResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierResponseDto create(SupplierRequestDto dto) {
        SupplierEntity entity = SupplierMapper.toEntity(dto);
        return SupplierMapper.toResponseDto(supplierRepository.save(entity));
    }

    public List<SupplierResponseDto> getAll() {
        return supplierRepository.findAll()
                .stream()
                .map(SupplierMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public SupplierResponseDto getByGuid(UUID guid) {
        SupplierEntity entity = supplierRepository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        return SupplierMapper.toResponseDto(entity);
    }

    public SupplierResponseDto update(UUID guid, SupplierRequestDto dto) {
        SupplierEntity entity = supplierRepository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setIsActive(dto.getIsActive());

        return SupplierMapper.toResponseDto(supplierRepository.save(entity));
    }

    public void delete(UUID guid) {
        supplierRepository.deleteByGuid(guid);
    }
}
