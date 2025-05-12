package com.simsys.warehouse.responsedto;

public class SystemConfigResponseDto {

    private Long id;
    private String name;
    private String configValue;
    private String description;

    public SystemConfigResponseDto() {
    }

    public SystemConfigResponseDto(Long id, String name, String configValue, String description) {
        this.id = id;
        this.name = name;
        this.configValue = configValue;
        this.description = description;
    }

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

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
