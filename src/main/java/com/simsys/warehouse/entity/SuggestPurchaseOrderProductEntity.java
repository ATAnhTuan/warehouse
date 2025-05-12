package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "suggest_purchase_order_products")
public class SuggestPurchaseOrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID productGuid;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suggest_purchase_order_id")
    private SuggestPurchaseOrderEntity suggestPurchaseOrder;

    public SuggestPurchaseOrderProductEntity(Long id, UUID productGuid, Integer quantity, Integer price, SuggestPurchaseOrderEntity suggestPurchaseOrder) {
        this.id = id;
        this.productGuid = productGuid;
        this.quantity = quantity;
        this.price = price;
        this.suggestPurchaseOrder = suggestPurchaseOrder;
    }

    public SuggestPurchaseOrderProductEntity() {

    }

    public SuggestPurchaseOrderProductEntity(UUID productGuid, Integer quantity, Integer price, SuggestPurchaseOrderEntity suggestPurchaseOrder) {
        this.productGuid = productGuid;
        this.quantity = quantity;
        this.price = price;
        this.suggestPurchaseOrder = suggestPurchaseOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public SuggestPurchaseOrderEntity getSuggestPurchaseOrder() {
        return suggestPurchaseOrder;
    }

    public void setSuggestOrder(SuggestPurchaseOrderEntity suggestOrder) {
        this.suggestPurchaseOrder = suggestOrder;
    }
}
