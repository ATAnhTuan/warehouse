package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;
    private UUID guid;

    public CategoryResponseDto() {
    }

    public CategoryResponseDto(Long id, String name, String description, UUID guid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.guid = guid;
    }

    // Getters & Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }
}
