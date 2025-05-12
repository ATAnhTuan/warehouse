package com.simsys.warehouse.service;

import com.simsys.warehouse.requestdto.OrderRequestDto;
import com.simsys.warehouse.entity.OrderEntity;
import com.simsys.warehouse.mapper.OrderMapper;
import com.simsys.warehouse.repository.OrderRepository;
import com.simsys.warehouse.responsedto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderResponseDto createOrder(OrderRequestDto dto) {
        OrderEntity entity = OrderMapper.toEntity(dto);
        OrderEntity saved = orderRepository.save(entity);
        return OrderMapper.toResponseDto(saved);
    }

    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public OrderResponseDto getByGuid(UUID guid) {
        OrderEntity entity = orderRepository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderMapper.toResponseDto(entity);
    }

    public void deleteByGuid(UUID guid) {
        orderRepository.deleteByGuid(guid);
    }

    public OrderResponseDto updateOrder(UUID guid, OrderRequestDto dto) {
        OrderEntity existing = orderRepository.findByGuid(guid)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existing.setCustomerGuid(dto.getCustomerGuid());
        existing.setDescription(dto.getDescription());
        existing.setTotalPrice(dto.getTotalPrice());
        existing.setIsActive(dto.getIsActive());

        // Optional: Update orderDetails if needed

        return OrderMapper.toResponseDto(orderRepository.save(existing));
    }
}
