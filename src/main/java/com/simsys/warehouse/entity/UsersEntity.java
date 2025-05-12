package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID guid;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "role_guid", nullable = false)
    private UUID roleGuid;

    // Constructors
    public UsersEntity() {
        this.guid = UUID.randomUUID(); // Default GUID generation
    }

    public UsersEntity(String username, String password, String email, String contactInfo, Boolean isActive, UUID roleGuid) {
        this.username = username;
        this.guid = UUID.randomUUID();
        this.password = password;
        this.email = email;
        this.contactInfo = contactInfo;
        this.isActive = isActive;
        this.roleGuid = roleGuid;
    }

    // Getters & Setters
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

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public UUID getRoleGuid() {
        return roleGuid;
    }

    public void setRoleGuid(UUID roleGuid) {
        this.roleGuid = roleGuid;
    }
}
