package com.simsys.warehouse.requestdto;

import java.util.UUID;

public class OrderDetailRequestDto {
    private UUID orderGuid;
    private UUID productGuid;
    private Integer quantity;

    public UUID getOrderGuid() {
        return orderGuid;
    }

    public void setOrderGuid(UUID orderGuid) {
        this.orderGuid = orderGuid;
    }

    public UUID getProductGuid() {
        return productGuid;
    }

    public void setProductGuid(UUID productGuid) {
        this.productGuid = productGuid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
