package com.simsys.warehouse.requestdtos;

public class SystemConfigRequestDto {

    private String name;
    private String configValue;
    private String description;

    public SystemConfigRequestDto() {
    }

    public SystemConfigRequestDto(String name, String configValue, String description) {
        this.name = name;
        this.configValue = configValue;
        this.description = description;
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
