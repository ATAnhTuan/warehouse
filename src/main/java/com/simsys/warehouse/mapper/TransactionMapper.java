package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.TransactionEntity;
import com.simsys.warehouse.requestdto.TransactionRequestDto;
import com.simsys.warehouse.responsedto.TransactionResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {

    public static TransactionEntity toEntity(TransactionRequestDto dto) {
        TransactionEntity entity = new TransactionEntity();
        entity.setMoney(dto.getMoney());
        entity.setCustomerGuid(dto.getCustomerGuid());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public static TransactionResponseDto toResponseDto(TransactionEntity entity) {
        return new TransactionResponseDto(
                entity.getId(),
                entity.getGuid(),
                entity.getMoney(),
                entity.getCreateDate(),
                entity.getCustomerGuid(),
                entity.getDescription()
        );
    }

    public static List<TransactionResponseDto> toResponseDtoList(List<TransactionEntity> entities) {
        return entities.stream()
                .map(TransactionMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
