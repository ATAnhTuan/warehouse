package com.simsys.warehouse.requestdto;

import java.util.UUID;

public class LocationRequestDto {
    private String locationName;
    private String description;
    private UUID inventoryGuid;

    // Getters & Setters
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
