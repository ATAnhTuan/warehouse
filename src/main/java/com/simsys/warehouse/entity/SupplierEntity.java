package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String phone;

    @Column(name = "is_active")
    private String isActive;

    public SupplierEntity() {
    }

    public SupplierEntity(String name, String address, String email, String phone, String isActive, UUID guid) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.isActive = isActive;
        this.guid = guid;
    }

    // Getters and Setters

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
