package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class ProductResponseDto {
    private final Long id;
    private final String name;
    private final Integer quantity;
    private final String description;
    private final String status;
    private final UUID guid;
    private final UUID categoryGuid;
    private final UUID variantGuid;
    private final CategoryResponseDto category;
    private final VariantResponseDto variant;

    public ProductResponseDto(Long id, String name, Integer quantity, String description, String status,
                              UUID guid, UUID categoryGuid, UUID variantGuid,
                              CategoryResponseDto category, VariantResponseDto variant) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.guid = guid;
        this.categoryGuid = categoryGuid;
        this.variantGuid = variantGuid;
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

    public UUID getGuid() {
        return guid;
    }

    public UUID getCategoryGuid() {
        return categoryGuid;
    }

    public UUID getVariantGuid() {
        return variantGuid;
    }

    public CategoryResponseDto getCategory() {
        return category;
    }

    public VariantResponseDto getVariant() {
        return variant;
    }
}
