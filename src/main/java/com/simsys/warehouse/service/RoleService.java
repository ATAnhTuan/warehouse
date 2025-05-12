package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.RoleEntity;
import com.simsys.warehouse.mapper.RoleMapper;
import com.simsys.warehouse.repository.RoleRepository;
import com.simsys.warehouse.requestdto.RoleRequestDto;
import com.simsys.warehouse.responsedto.RoleResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleResponseDto create(RoleRequestDto dto) {
        RoleEntity role = RoleMapper.toEntity(dto);
        RoleEntity saved = roleRepository.save(role);
        return RoleMapper.toResponseDto(saved);
    }

    public List<RoleResponseDto> findAll() {
        return RoleMapper.toResponseDtoList(roleRepository.findAll());
    }

    public Optional<RoleResponseDto> findById(Long id) {
        return roleRepository.findById(id).map(RoleMapper::toResponseDto);
    }

    public Optional<RoleResponseDto> findByGuid(UUID guid) {
        return roleRepository.findByGuid(guid).map(RoleMapper::toResponseDto);
    }

    public Optional<RoleResponseDto> update(Long id, RoleRequestDto dto) {
        return roleRepository.findById(id).map(existing -> {
            existing.setRoleName(dto.getRoleName());
            existing.setDescription(dto.getDescription());
            return RoleMapper.toResponseDto(roleRepository.save(existing));
        });
    }

    public boolean delete(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
