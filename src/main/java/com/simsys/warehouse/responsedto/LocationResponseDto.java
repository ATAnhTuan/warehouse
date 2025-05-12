package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class LocationResponseDto {
    private UUID guid;
    private String locationName;
    private String description;
    private UUID inventoryGuid;

    public LocationResponseDto(UUID guid, String locationName, String description, UUID inventoryGuid) {
        this.guid = guid;
        this.locationName = locationName;
        this.description = description;
        this.inventoryGuid = inventoryGuid;
    }

    // Getters & Setters
    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getInventoryGuid() {
        return inventoryGuid;
    }

    public void setInventoryGuid(UUID inventoryGuid) {
        this.inventoryGuid = inventoryGuid;
    }
}
