package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.OrderDetailEntity;
import com.simsys.warehouse.requestdto.OrderDetailRequestDto;
import com.simsys.warehouse.responsedto.OrderDetailResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailMapper {

    public static OrderDetailEntity toEntity(OrderDetailRequestDto dto, java.util.UUID orderGuid) {
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setOrderGuid(orderGuid);
        entity.setProductGuid(dto.getProductGuid());
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

    public static OrderDetailResponseDto toResponseDto(OrderDetailEntity entity) {
        return new OrderDetailResponseDto(
                entity.getId(),
                entity.getGuid(),
                entity.getOrderGuid(),
                entity.getProductGuid(),
                entity.getQuantity()
        );
    }

    public static List<OrderDetailResponseDto> toResponseDtoList(List<OrderDetailEntity> entities) {
        return entities.stream()
                .map(OrderDetailMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
