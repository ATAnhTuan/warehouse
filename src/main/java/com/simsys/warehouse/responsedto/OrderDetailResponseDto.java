package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class OrderDetailResponseDto {
    private final Long id;
    private final UUID guid;
    private final UUID orderGuid;
    private final UUID productGuid;
    private final Integer quantity;

    public OrderDetailResponseDto(Long id, UUID guid, UUID orderGuid, UUID productGuid, Integer quantity) {
        this.id = id;
        this.guid = guid;
        this.orderGuid = orderGuid;
        this.productGuid = productGuid;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public UUID getGuid() {
        return guid;
    }

    public UUID getOrderGuid() {
        return orderGuid;
    }

    public UUID getProductGuid() {
        return productGuid;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
