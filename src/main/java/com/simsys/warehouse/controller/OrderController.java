package com.simsys.warehouse.controller;


import com.simsys.warehouse.requestdto.OrderRequestDto;
import com.simsys.warehouse.responsedto.OrderResponseDto;
import com.simsys.warehouse.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto dto) {
        return orderService.createOrder(dto);
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{guid}")
    public OrderResponseDto getOrder(@PathVariable UUID guid) {
        return orderService.getByGuid(guid);
    }

    @PutMapping("/{guid}")
    public OrderResponseDto updateOrder(@PathVariable UUID guid, @RequestBody OrderRequestDto dto) {
        return orderService.updateOrder(guid, dto);
    }

    @DeleteMapping("/{guid}")
    public void deleteOrder(@PathVariable UUID guid) {
        orderService.deleteByGuid(guid);
    }
}
