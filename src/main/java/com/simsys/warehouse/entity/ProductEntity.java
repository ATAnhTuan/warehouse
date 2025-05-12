package com.simsys.warehouse.entity;

import jakarta.persistence.*;

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

    public ProductEntity() {
    }

    public ProductEntity(String name, Integer quantity, String description, String status, UUID guid, UUID categoryGuid, UUID variantGuid, VariantEntity variant, CategoryEntity category) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.guid = guid;
        this.categoryGuid = categoryGuid;
        this.variantGuid = variantGuid;
        this.variant = variant;
        this.category = category;
    }
// Getters and Setters


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
}
