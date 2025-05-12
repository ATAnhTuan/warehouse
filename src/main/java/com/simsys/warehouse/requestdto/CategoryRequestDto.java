package com.simsys.warehouse.requestdto;

public class CategoryRequestDto {
    private String name;
    private String description;

    // Constructors
    public CategoryRequestDto() {
    }

    public CategoryRequestDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters & Setters
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
}
