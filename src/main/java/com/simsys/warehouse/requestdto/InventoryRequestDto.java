package com.simsys.warehouse.requestdto;

import java.util.UUID;

public class InventoryRequestDto {
    private String name;
    private String description;
    private Integer quantity;
    private UUID userGuid;

    // Constructors
    public InventoryRequestDto() {
    }

    public InventoryRequestDto(String name, String description, Integer quantity, UUID userGuid) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.userGuid = userGuid;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UUID getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;
    }
}
