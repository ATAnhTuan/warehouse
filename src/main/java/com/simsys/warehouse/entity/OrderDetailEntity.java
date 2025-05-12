package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "order_details")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @Column(name = "order_guid", nullable = false)
    private UUID orderGuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_guid", referencedColumnName = "guid", insertable = false, updatable = false)
    private OrderEntity order;

    @Column(name = "product_guid", nullable = false)
    private UUID productGuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_guid", referencedColumnName = "guid", insertable = false, updatable = false)
    private ProductEntity product;

    @Column(nullable = false)
    private Integer quantity;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(UUID orderGuid, UUID productGuid, Integer quantity) {
        this.orderGuid = orderGuid;
        this.productGuid = productGuid;
        this.quantity = quantity;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public UUID getOrderGuid() {
        return orderGuid;
    }

    public void setOrderGuid(UUID orderGuid) {
        this.orderGuid = orderGuid;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public UUID getProductGuid() {
        return productGuid;
    }

    public void setProductGuid(UUID productGuid) {
        this.productGuid = productGuid;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
