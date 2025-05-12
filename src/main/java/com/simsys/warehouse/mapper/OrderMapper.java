package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.OrderDetailEntity;
import com.simsys.warehouse.entity.OrderEntity;
import com.simsys.warehouse.requestdto.OrderDetailRequestDto;
import com.simsys.warehouse.requestdto.OrderRequestDto;
import com.simsys.warehouse.responsedto.OrderDetailResponseDto;
import com.simsys.warehouse.responsedto.OrderResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderEntity toEntity(OrderRequestDto dto) {
        OrderEntity entity = new OrderEntity(
                dto.getCustomerGuid(),
                dto.getDescription(),
                dto.getTotalPrice(),
                dto.getIsActive()
        );
        return entity;
    }


    public static OrderResponseDto toResponseDto(OrderEntity order) {
        List<OrderDetailResponseDto> detailDtos = order.getOrderDetails().stream()
                .map(detail -> new OrderDetailResponseDto(
                        detail.getId(),
                        detail.getGuid(),
                        detail.getOrderGuid(),
                        detail.getProductGuid(),
                        detail.getQuantity()
                ))
                .collect(Collectors.toList());

        return new OrderResponseDto(
                order.getId(),
                order.getGuid(),
                order.getCustomerGuid(),
                order.getTransactionGuid(),
                order.getDescription(),
                order.getTotalPrice(),
                order.getIsActive(),
                detailDtos
        );
    }
}
