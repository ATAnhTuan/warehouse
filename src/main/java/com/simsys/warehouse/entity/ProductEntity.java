package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer quantity;

    private String description;

    private String status;

    @Column(name = "image")
    private String image;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @Column(name = "category_guid", nullable = false)
    private UUID categoryGuid;

    @Column(name = "variant_guid", nullable = false)
    private UUID variantGuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_guid", referencedColumnName = "guid", insertable = false, updatable = false)
    private VariantEntity variant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_guid", referencedColumnName = "guid", insertable = false, updatable = false)
    private CategoryEntity category;

    @Column(name = "consignment_guid")
    private UUID consignmentGuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consignment_guid", referencedColumnName = "guid", insertable = false, updatable = false)
    private ConsignmentEntity consignment;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    public ProductEntity() {
    }

    public ProductEntity(String name, Integer quantity, String description, String status, UUID guid,
                         UUID categoryGuid, UUID variantGuid, UUID consignmentGuid,
                         VariantEntity variant, CategoryEntity category, ConsignmentEntity consignment,
                         String image, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.guid = guid;
        this.categoryGuid = categoryGuid;
        this.variantGuid = variantGuid;
        this.consignmentGuid = consignmentGuid;
        this.variant = variant;
        this.category = category;
        this.consignment = consignment;
        this.image = image;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public UUID getCategoryGuid() {
        return categoryGuid;
    }

    public void setCategoryGuid(UUID categoryGuid) {
        this.categoryGuid = categoryGuid;
    }

    public UUID getVariantGuid() {
        return variantGuid;
    }

    public void setVariantGuid(UUID variantGuid) {
        this.variantGuid = variantGuid;
    }

    public VariantEntity getVariant() {
        return variant;
    }

    public void setVariant(VariantEntity variant) {
        this.variant = variant;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public UUID getConsignmentGuid() {
        return consignmentGuid;
    }

    public void setConsignmentGuid(UUID consignmentGuid) {
        this.consignmentGuid = consignmentGuid;
    }

    public ConsignmentEntity getConsignment() {
        return consignment;
    }

    public void setConsignment(ConsignmentEntity consignment) {
        this.consignment = consignment;
    }
}
