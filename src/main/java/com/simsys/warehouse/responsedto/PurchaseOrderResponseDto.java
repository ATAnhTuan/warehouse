package com.simsys.warehouse.responsedto;

import java.util.List;
import java.util.UUID;

public class PurchaseOrderResponseDto {

    private UUID guid;
    private UUID supplierGuid;
    private String description;
    private Integer totalPrice;
    private String isActive;
    private List<PurchaseOrderDetailResponseDto> purchaseOrderDetails;

    // Constructors, Getters, Setters

    public PurchaseOrderResponseDto(UUID guid, UUID supplierGuid, String description, Integer totalPrice, String isActive, List<PurchaseOrderDetailResponseDto> purchaseOrderDetails) {
        this.guid = guid;
        this.supplierGuid = supplierGuid;
        this.description = description;
        this.totalPrice = totalPrice;
        this.isActive = isActive;
        this.purchaseOrderDetails = purchaseOrderDetails;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

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

    public List<PurchaseOrderDetailResponseDto> getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(List<PurchaseOrderDetailResponseDto> purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }
}
