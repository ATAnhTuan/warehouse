package com.simsys.warehouse.responsedto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ConsignmentResponseDto {
    private Long id;
    private UUID guid;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private LocalDateTime createDate;
    private UUID supplierGuid;
    private UUID purchaseOrderGuid;

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public UUID getSupplierGuid() {
        return supplierGuid;
    }

    public void setSupplierGuid(UUID supplierGuid) {
        this.supplierGuid = supplierGuid;
    }

    public UUID getPurchaseOrderGuid() {
        return purchaseOrderGuid;
    }

    public void setPurchaseOrderGuid(UUID purchaseOrderGuid) {
        this.purchaseOrderGuid = purchaseOrderGuid;
    }
}
