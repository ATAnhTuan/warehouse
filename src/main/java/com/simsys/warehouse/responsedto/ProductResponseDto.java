package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class ProductResponseDto {
    private final Long id;
    private final String name;
    private final Integer quantity;
    private final String description;
    private final String status;
    private final String image; // Thêm image
    private final UUID guid;
    private final UUID categoryGuid;
    private final UUID variantGuid;
    private final UUID consignmentGuid; // Thêm consignmentGuid
    private final CategoryResponseDto category;
    private final VariantResponseDto variant;

    public ProductResponseDto(Long id, String name, Integer quantity, String description, String status,
                              String image, UUID guid, UUID categoryGuid, UUID variantGuid, UUID consignmentGuid,
                              CategoryResponseDto category, VariantResponseDto variant) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.image = image;
        this.guid = guid;
        this.categoryGuid = categoryGuid;
        this.variantGuid = variantGuid;
        this.consignmentGuid = consignmentGuid;
        this.category = category;
        this.variant = variant;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public UUID getGuid() {
        return guid;
    }

    public UUID getCategoryGuid() {
        return categoryGuid;
    }

    public UUID getVariantGuid() {
        return variantGuid;
    }

    public UUID getConsignmentGuid() {
        return consignmentGuid;
    }

    public CategoryResponseDto getCategory() {
        return category;
    }

    public VariantResponseDto getVariant() {
        return variant;
    }
}
