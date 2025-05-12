package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class UsersResponseDto {
    private Long id;
    private String username;
    private String email;
    private String contactInfo;
    private Boolean isActive;
    private UUID guid;
    private UUID roleGuid;

    public UsersResponseDto(Long id, String username, String email, String contactInfo,
                            Boolean isActive, UUID guid, UUID roleGuid) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.contactInfo = contactInfo;
        this.isActive = isActive;
        this.guid = guid;
        this.roleGuid = roleGuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public UUID getRoleGuid() {
        return roleGuid;
    }

    public void setRoleGuid(UUID roleGuid) {
        this.roleGuid = roleGuid;
    }
}
