package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "suggest_purchase_orders")
public class SuggestPurchaseOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @Column(nullable = false)
    private Integer quantity;

    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "user_guid", nullable = false)
    private UUID userGuid;

    @Column(name = "supplier_guid", nullable = false)
    private UUID supplierGuid;

    @OneToMany(mappedBy = "suggestPurchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SuggestPurchaseOrderProductEntity> products;

    public SuggestPurchaseOrderEntity(UUID guid, Integer quantity, String description, Integer price, String isActive, LocalDateTime createDate, UUID userGuid, UUID supplierGuid, List<SuggestPurchaseOrderProductEntity> products) {
        this.guid = guid;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
        this.createDate = createDate;
        this.userGuid = userGuid;
        this.supplierGuid = supplierGuid;
        this.products = products;
    }

    public SuggestPurchaseOrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public UUID getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;
    }

    public UUID getSupplierGuid() {
        return supplierGuid;
    }

    public void setSupplierGuid(UUID supplierGuid) {
        this.supplierGuid = supplierGuid;
    }

    public List<SuggestPurchaseOrderProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<SuggestPurchaseOrderProductEntity> products) {
        this.products = products;
    }
}
