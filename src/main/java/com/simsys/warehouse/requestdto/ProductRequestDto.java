package com.simsys.warehouse.requestdto;

import java.util.UUID;

public class ProductRequestDto {
    private String name;
    private Integer quantity;
    private String description;
    private String status;
    private String image; // Thêm image
    private UUID categoryGuid;
    private UUID variantGuid;
    private UUID consignmentGuid; // Thêm consignmentGuid

    // Getters & Setters
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

    public UUID getConsignmentGuid() {
        return consignmentGuid;
    }

    public void setConsignmentGuid(UUID consignmentGuid) {
        this.consignmentGuid = consignmentGuid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
