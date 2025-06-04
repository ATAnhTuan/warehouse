package com.simsys.warehouse.requestdto;

import java.math.BigDecimal;
import java.util.UUID;

public class ConsignmentRequestDto {
    private String sku;
    private String name;
    private String description;
    private BigDecimal payPrice;
    private Integer quantity;
    private UUID supplierGuid;
    private UUID purchaseOrderGuid;

    public ConsignmentRequestDto(
            String sku,
            String name,
            String description,
            BigDecimal payPrice,
            Integer quantity,
            UUID supplierGuid,
            UUID purchaseOrderGuid
    ) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.payPrice = payPrice;
        this.quantity = quantity;
        this.supplierGuid = supplierGuid;
        this.purchaseOrderGuid = purchaseOrderGuid;
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

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
