package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class RoleResponseDto {
    private final Long id;
    private UUID guid;
    private String roleName;
    private String description;

    public RoleResponseDto(Long id, UUID guid, String roleName, String description) {
        this.id = id;
        this.guid = guid;
        this.roleName = roleName;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
