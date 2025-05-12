package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class PurchaseOrderDetailResponseDto {

    private UUID guid;
    private UUID productGuid;
    private Integer quantity;

    // Constructors, Getters, Setters

    public PurchaseOrderDetailResponseDto(UUID guid, UUID productGuid, Integer quantity) {
        this.guid = guid;
        this.productGuid = productGuid;
        this.quantity = quantity;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
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
