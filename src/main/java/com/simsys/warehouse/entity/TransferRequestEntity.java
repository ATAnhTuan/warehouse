package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transfer_requests")
public class TransferRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID guid;

    @Column(name = "from_inventory_guid", nullable = false)
    private UUID fromInventoryGuid;

    @Column(name = "to_inventory_guid", nullable = false)
    private UUID toInventoryGuid;

    @Column(name = "user_guid", nullable = false)
    private UUID userGuid;

    @Column(name = "product_guid", nullable = false)
    private UUID productGuid;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    private String note;

    public TransferRequestEntity() {
    }

    public TransferRequestEntity(UUID fromInventoryGuid, UUID toInventoryGuid, UUID userGuid,
                                 UUID productGuid, Integer quantity, LocalDateTime createDate, String note) {
        this.fromInventoryGuid = fromInventoryGuid;
        this.toInventoryGuid = toInventoryGuid;
        this.userGuid = userGuid;
        this.productGuid = productGuid;
        this.quantity = quantity;
        this.createDate = createDate;
        this.note = note;
    }

    // Getters and Setters

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public UUID getFromInventoryGuid() {
        return fromInventoryGuid;
    }

    public void setFromInventoryGuid(UUID fromInventoryGuid) {
        this.fromInventoryGuid = fromInventoryGuid;
    }

    public UUID getToInventoryGuid() {
        return toInventoryGuid;
    }

    public void setToInventoryGuid(UUID toInventoryGuid) {
        this.toInventoryGuid = toInventoryGuid;
    }

    public UUID getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;
    }

    public UUID getProductGuid() {
        return productGuid;
    }

    public void setProductGuid(UUID productGuid) {
        this.productGuid = productGuid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
