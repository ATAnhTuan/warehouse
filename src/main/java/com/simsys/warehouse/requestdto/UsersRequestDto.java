package com.simsys.warehouse.requestdto;

import java.util.UUID;

public class UsersRequestDto {
    private String username;
    private String password;
    private String email;
    private String contactInfo;
    private Boolean isActive;
    private UUID roleGuid;

    public UsersRequestDto(String username, String password, String email, String contactInfo, Boolean isActive, UUID roleGuid) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactInfo = contactInfo;
        this.isActive = isActive;
        this.roleGuid = roleGuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UUID getRoleGuid() {
        return roleGuid;
    }

    public void setRoleGuid(UUID roleGuid) {
        this.roleGuid = roleGuid;
    }
}
