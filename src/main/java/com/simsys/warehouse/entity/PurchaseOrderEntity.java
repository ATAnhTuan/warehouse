package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @Column(name = "supplier_guid", nullable = false)
    private UUID supplierGuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_guid", referencedColumnName = "guid", insertable = false, updatable = false)
    private SupplierEntity supplier;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private String isActive;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PurchaseOrderDetailEntity> purchaseOrderDetails = new ArrayList<>();

    public PurchaseOrderEntity() {
    }

    public PurchaseOrderEntity(UUID supplierGuid, String description, Integer totalPrice, String isActive) {
        this.supplierGuid = supplierGuid;
        this.description = description;
        this.totalPrice = totalPrice;
        this.isActive = isActive;
    }

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

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
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

    public List<PurchaseOrderDetailEntity> getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(List<PurchaseOrderDetailEntity> purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }
}
