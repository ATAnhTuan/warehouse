package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class SuggestPurchaseOrderProductResponseDto {
    private UUID productGuid;
    private Integer quantity;
    private Integer price;

    public SuggestPurchaseOrderProductResponseDto(UUID productGuid, Integer quantity, Integer price) {
        this.productGuid = productGuid;
        this.quantity = quantity;
        this.price = price;
    }

    public SuggestPurchaseOrderProductResponseDto() {

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
