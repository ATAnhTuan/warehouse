package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.RoleEntity;
import com.simsys.warehouse.requestdto.RoleRequestDto;
import com.simsys.warehouse.responsedto.RoleResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper {

    public static RoleEntity toEntity(RoleRequestDto dto) {
        if (dto == null) return null;
        RoleEntity role = new RoleEntity();
        role.setRoleName(dto.getRoleName());
        role.setDescription(dto.getDescription());
        return role;
    }

    public static RoleResponseDto toResponseDto(RoleEntity role) {
        if (role == null) return null;
        return new RoleResponseDto(
                role.getId(),
                role.getGuid(),
                role.getRoleName(),
                role.getDescription()
        );
    }

    public static List<RoleResponseDto> toResponseDtoList(List<RoleEntity> roles) {
        return roles.stream().map(RoleMapper::toResponseDto).collect(Collectors.toList());
    }
}
