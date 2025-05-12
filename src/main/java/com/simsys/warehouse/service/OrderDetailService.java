package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.OrderDetailEntity;
import com.simsys.warehouse.mapper.OrderDetailMapper;
import com.simsys.warehouse.repository.OrderDetailRepository;
import com.simsys.warehouse.requestdto.OrderDetailRequestDto;
import com.simsys.warehouse.responsedto.OrderDetailResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public OrderDetailResponseDto create(OrderDetailRequestDto dto) {
        OrderDetailEntity entity = OrderDetailMapper.toEntity(dto, dto.getOrderGuid());
        OrderDetailEntity saved = orderDetailRepository.save(entity);
        return OrderDetailMapper.toResponseDto(saved);
    }

    public List<OrderDetailResponseDto> getAll() {
        List<OrderDetailEntity> entities = orderDetailRepository.findAll();
        return OrderDetailMapper.toResponseDtoList(entities);
    }

    public OrderDetailResponseDto getByGuid(UUID guid) {
        OrderDetailEntity entity = orderDetailRepository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Order detail not found"));
        return OrderDetailMapper.toResponseDto(entity);
    }

    public void deleteByGuid(UUID guid) {
        orderDetailRepository.deleteByGuid(guid);
    }

    public List<OrderDetailResponseDto> getByOrderGuid(UUID orderGuid) {
        List<OrderDetailEntity> entities = orderDetailRepository.findAllByOrderGuid(orderGuid);
        return OrderDetailMapper.toResponseDtoList(entities);
    }

    public OrderDetailResponseDto update(UUID guid, OrderDetailRequestDto dto) {
        OrderDetailEntity entity = orderDetailRepository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Order detail not found"));

        entity.setOrderGuid(dto.getOrderGuid());
        entity.setProductGuid(dto.getProductGuid());
        entity.setQuantity(dto.getQuantity());

        OrderDetailEntity saved = orderDetailRepository.save(entity);
        return OrderDetailMapper.toResponseDto(saved);
    }
}
