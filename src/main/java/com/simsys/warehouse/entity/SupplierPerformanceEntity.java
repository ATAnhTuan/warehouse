package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "supplier_performance")
public class SupplierPerformanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @Column(nullable = false)
    private UUID supplierGuid;

    @Column(nullable = false)
    private UUID consignmentGuid;

    @Column(nullable = false)
    private UUID userGuid;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal onTimeDeliveryRate;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal productQualityRating;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal supplyCompletionRate;

    private String description;

    // Getters and Setters

    public Long getId() {
        return id;
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
