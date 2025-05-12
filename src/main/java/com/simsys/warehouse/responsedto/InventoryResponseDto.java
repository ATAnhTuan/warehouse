package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class InventoryResponseDto {
    private Long id;
    private UUID guid;
    private String name;
    private String description;
    private Integer quantity;
    private UUID userGuid;

    public InventoryResponseDto() {
    }

    public InventoryResponseDto(Long id, UUID guid, String name, String description, Integer quantity, UUID userGuid) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.userGuid = userGuid;
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
