package com.simsys.warehouse.requestdto;

import java.util.List;
import java.util.UUID;

public class SuggestPurchaseOrderRequestDto {
    private Integer quantity;
    private String description;
    private Integer price;
    private String isActive;
    private UUID userGuid;
    private UUID supplierGuid;
    private List<SuggestPurchaseOrderProductRequestDto> products;


    public SuggestPurchaseOrderRequestDto(Integer quantity, String description, Integer price, String isActive, UUID userGuid, UUID supplierGuid, List<SuggestPurchaseOrderProductRequestDto> products) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
        this.userGuid = userGuid;
        this.supplierGuid = supplierGuid;
        this.products = products;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public UUID getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;
    }

    public UUID getSupplierGuid() {
        return supplierGuid;
    }

    public void setSupplierGuid(UUID supplierGuid) {
        this.supplierGuid = supplierGuid;
    }

    public List<SuggestPurchaseOrderProductRequestDto> getProducts() {
        return products;
    }

    public void setProducts(List<SuggestPurchaseOrderProductRequestDto> products) {
        this.products = products;
    }
}
