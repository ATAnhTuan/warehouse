package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "locations")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID guid;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    private String description;

    @Column(name = "inventory_guid", nullable = false)
    private UUID inventoryGuid;

    public LocationEntity() {
        this.guid = UUID.randomUUID();
    }

    public LocationEntity(String locationName, String description, UUID inventoryGuid) {
        this.guid = UUID.randomUUID();
        this.locationName = locationName;
        this.description = description;
        this.inventoryGuid = inventoryGuid;
    }

    // Getters & Setters
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
