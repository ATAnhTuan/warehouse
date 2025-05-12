package com.simsys.warehouse.responsedto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SuggestPurchaseOrderResponseDto {
    private Long id;
    private UUID guid;
    private Integer quantity;
    private String description;
    private Integer price;
    private String isActive;
    private LocalDateTime createDate;
    private UUID userGuid;
    private UUID supplierGuid;
    private List<SuggestPurchaseOrderProductResponseDto> products;

    public SuggestPurchaseOrderResponseDto(Long id, UUID guid, Integer quantity, String description, Integer price, String isActive, LocalDateTime createDate, UUID userGuid, UUID supplierGuid, List<SuggestPurchaseOrderProductResponseDto> products) {
        this.id = id;
        this.guid = guid;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
        this.createDate = createDate;
        this.userGuid = userGuid;
        this.supplierGuid = supplierGuid;
        this.products = products;
    }

    public SuggestPurchaseOrderResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
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

    public List<SuggestPurchaseOrderProductResponseDto> getProducts() {
        return products;
    }

    public void setProducts(List<SuggestPurchaseOrderProductResponseDto> products) {
        this.products = products;
    }
}
