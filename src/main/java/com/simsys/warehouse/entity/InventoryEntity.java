package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "inventories")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();  // Tự động khởi tạo khi tạo mới

    @Column(nullable = false)
    private String name;

    private String description;

    private Integer quantity;

    @Column(name = "user_guid", nullable = false)
    private UUID userGuid;

    public InventoryEntity() {
    }

    public InventoryEntity(String name, String description, Integer quantity, UUID userGuid) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.userGuid = userGuid;
        this.guid = UUID.randomUUID(); // Đảm bảo tạo guid mới trong constructor
    }

    // ===== Getters and Setters =====
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UUID getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;
    }
}
