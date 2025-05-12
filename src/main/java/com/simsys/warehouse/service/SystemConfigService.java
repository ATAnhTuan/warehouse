package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.SystemConfigEntity;
import com.simsys.warehouse.mapper.SystemConfigMapper;
import com.simsys.warehouse.repository.SystemConfigRepository;
import com.simsys.warehouse.requestdtos.SystemConfigRequestDto;
import com.simsys.warehouse.responsedto.SystemConfigResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemConfigService {

    private final SystemConfigRepository repository;

    public SystemConfigService(SystemConfigRepository repository) {
        this.repository = repository;
    }

    public SystemConfigEntity create(SystemConfigRequestDto dto) {
        SystemConfigEntity config = SystemConfigMapper.toEntity(dto);
        return repository.save(config);
    }

    public List<SystemConfigResponseDto> findAll() {
        return SystemConfigMapper.toResponseDtoList(repository.findAll());
    }

    public Optional<SystemConfigResponseDto> findById(Long id) {
        return repository.findById(id)
                .map(SystemConfigMapper::toResponseDto);
    }

    public Optional<SystemConfigResponseDto> update(Long id, SystemConfigRequestDto dto) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setConfigValue(dto.getConfigValue());
                    existing.setDescription(dto.getDescription());
                    return SystemConfigMapper.toResponseDto(repository.save(existing));
                });
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
