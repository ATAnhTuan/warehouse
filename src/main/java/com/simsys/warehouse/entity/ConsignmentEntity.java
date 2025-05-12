package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "consignments", uniqueConstraints = @UniqueConstraint(columnNames = "sku"))
public class ConsignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private UUID guid = UUID.randomUUID();

    @Column(nullable = false)
    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    private LocalDateTime createDate = LocalDateTime.now();

    // Foreign key thủ công liên kết với Supplier
    @Column(nullable = false)
    private UUID supplierGuid;

    // Foreign key thủ công liên kết với PurchaseOrder
    @Column(nullable = false)
    private UUID purchaseOrderGuid;

    // Getters & Setters

    public Long getId() {
        return id;
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
