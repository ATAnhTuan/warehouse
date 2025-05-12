package com.simsys.warehouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "system_configs")
public class SystemConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "config_value", nullable = false)
    private String configValue;

    private String description;

    // Constructors
    public SystemConfigEntity() {
    }

    public SystemConfigEntity(String name, String configValue, String description) {
        this.name = name;
        this.configValue = configValue;
        this.description = description;
    }

    public SystemConfigEntity(Long id, String name, String configValue, String description) {
        this.id = id;
        this.name = name;
        this.configValue = configValue;
        this.description = description;
    }

    // Getters and Setters
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
