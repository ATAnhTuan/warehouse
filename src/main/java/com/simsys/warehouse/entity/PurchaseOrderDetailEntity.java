package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "purchase_order_details")
public class PurchaseOrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID guid = UUID.randomUUID();

    @Column(name = "purchase_order_guid", nullable = false)
    private UUID purchaseOrderGuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_guid", referencedColumnName = "guid", insertable = false, updatable = false)
    private PurchaseOrderEntity purchaseOrder;

    @Column(name = "product_guid", nullable = false)
    private UUID productGuid;

    @Column(nullable = false)
    private Integer quantity;

    public PurchaseOrderDetailEntity() {
    }

    public PurchaseOrderDetailEntity(UUID purchaseOrderGuid, UUID productGuid, Integer quantity) {
        this.purchaseOrderGuid = purchaseOrderGuid;
        this.productGuid = productGuid;
        this.quantity = quantity;
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

    public UUID getPurchaseOrderGuid() {
        return purchaseOrderGuid;
    }

    public void setPurchaseOrderGuid(UUID purchaseOrderGuid) {
        this.purchaseOrderGuid = purchaseOrderGuid;
    }

    public PurchaseOrderEntity getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrderEntity purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public UUID getProductGuid() {
        return productGuid;
    }

    public void setProductGuid(UUID productGuid) {
        this.productGuid = productGuid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
