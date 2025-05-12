package com.simsys.warehouse.requestdto;

import java.util.UUID;

public class PurchaseOrderDetailRequestDto {

    private UUID productGuid;
    private Integer quantity;

    // Getters and Setters

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
