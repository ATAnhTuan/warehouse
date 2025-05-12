package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.UsersEntity;
import com.simsys.warehouse.requestdto.UsersRequestDto;
import com.simsys.warehouse.responsedto.UsersResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class UsersMapper {

    public static UsersEntity toEntity(UsersRequestDto dto) {
        if (dto == null) return null;
        UsersEntity user = new UsersEntity();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setContactInfo(dto.getContactInfo());
        user.setIsActive(dto.getActive());
        user.setRoleGuid(dto.getRoleGuid());
        return user;
    }

    public static UsersResponseDto toResponseDto(UsersEntity user) {
        if (user == null) return null;
        return new UsersResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getContactInfo(),
                user.getIsActive(),
                user.getGuid(),
                user.getRoleGuid()
        );
    }

    public static List<UsersResponseDto> toResponseDtoList(List<UsersEntity> users) {
        return users.stream().map(UsersMapper::toResponseDto).collect(Collectors.toList());
    }
}
