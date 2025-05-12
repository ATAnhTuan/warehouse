package com.simsys.warehouse.requestdto;

import java.math.BigDecimal;
import java.util.UUID;

public class SupplierPerformanceRequestDto {
    private UUID supplierGuid;
    private UUID consignmentGuid;
    private UUID userGuid;
    private BigDecimal onTimeDeliveryRate;
    private BigDecimal productQualityRating;
    private BigDecimal supplyCompletionRate;
    private String description;

    public UUID getSupplierGuid() {
        return supplierGuid;
    }

    public void setSupplierGuid(UUID supplierGuid) {
        this.supplierGuid = supplierGuid;
    }

    public UUID getConsignmentGuid() {
        return consignmentGuid;
    }

    public void setConsignmentGuid(UUID consignmentGuid) {
        this.consignmentGuid = consignmentGuid;
    }

    public UUID getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;
    }

    public BigDecimal getOnTimeDeliveryRate() {
        return onTimeDeliveryRate;
    }

    public void setOnTimeDeliveryRate(BigDecimal onTimeDeliveryRate) {
        this.onTimeDeliveryRate = onTimeDeliveryRate;
    }

    public BigDecimal getProductQualityRating() {
        return productQualityRating;
    }

    public void setProductQualityRating(BigDecimal productQualityRating) {
        this.productQualityRating = productQualityRating;
    }

    public BigDecimal getSupplyCompletionRate() {
        return supplyCompletionRate;
    }

    public void setSupplyCompletionRate(BigDecimal supplyCompletionRate) {
        this.supplyCompletionRate = supplyCompletionRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
