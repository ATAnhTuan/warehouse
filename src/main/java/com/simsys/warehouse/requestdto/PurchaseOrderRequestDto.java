package com.simsys.warehouse.requestdto;

import java.util.List;
import java.util.UUID;

public class PurchaseOrderRequestDto {

    private UUID supplierGuid;
    private String description;
    private Integer totalPrice;
    private String isActive;
    private List<PurchaseOrderDetailRequestDto> purchaseOrderDetails;

    // Getters and Setters

    public UUID getSupplierGuid() {
        return supplierGuid;
    }

    public void setSupplierGuid(UUID supplierGuid) {
        this.supplierGuid = supplierGuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public List<PurchaseOrderDetailRequestDto> getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(List<PurchaseOrderDetailRequestDto> purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }
}
