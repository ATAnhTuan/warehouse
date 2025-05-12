package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.OrderDetailRequestDto;
import com.simsys.warehouse.responsedto.OrderDetailResponseDto;
import com.simsys.warehouse.service.OrderDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order-details")
@Tag(name = "Order Details")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/{orderGuid}")
    public OrderDetailResponseDto createOrderDetail(
            @RequestBody OrderDetailRequestDto dto
    ) {
        return orderDetailService.create(dto);
    }

    @GetMapping
    public List<OrderDetailResponseDto> getAllOrderDetails() {
        return orderDetailService.getAll();
    }

    @GetMapping("/{guid}")
    public OrderDetailResponseDto getOrderDetailByGuid(@PathVariable UUID guid) {
        return orderDetailService.getByGuid(guid);
    }

    @DeleteMapping("/{guid}")
    public void deleteOrderDetailByGuid(@PathVariable UUID guid) {
        orderDetailService.deleteByGuid(guid);
    }

    @GetMapping("/order/{orderGuid}")
    public List<OrderDetailResponseDto> getOrderDetailsByOrderGuid(@PathVariable UUID orderGuid) {
        return orderDetailService.getByOrderGuid(orderGuid);
    }

    @PutMapping("/{guid}")
    public OrderDetailResponseDto updateOrderDetail(
            @PathVariable UUID guid,
            @RequestBody OrderDetailRequestDto dto
    ) {
        return orderDetailService.update(guid, dto);
    }
}
