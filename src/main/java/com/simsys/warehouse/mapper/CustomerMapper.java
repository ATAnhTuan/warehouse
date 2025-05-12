package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.CustomerEntity;
import com.simsys.warehouse.requestdto.CustomerRequestDto;
import com.simsys.warehouse.responsedto.CustomerResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerEntity toEntity(CustomerRequestDto dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setBankCard(dto.getBankCard());
        return entity;
    }

    public static CustomerResponseDto toResponseDto(CustomerEntity entity) {
        return new CustomerResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getBankCard(),
                entity.getGuid()
        );
    }

    public static List<CustomerResponseDto> toResponseDtoList(List<CustomerEntity> entities) {
        return entities.stream().map(CustomerMapper::toResponseDto).collect(Collectors.toList());
    }
}
