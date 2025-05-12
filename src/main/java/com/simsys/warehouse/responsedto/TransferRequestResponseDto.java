package com.simsys.warehouse.responsedto;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransferRequestResponseDto {
    private UUID guid;
    private UUID fromInventoryGuid;
    private UUID toInventoryGuid;
    private UUID userGuid;
    private UUID productGuid;
    private Integer quantity;
    private LocalDateTime createDate;
    private String note;

    public TransferRequestResponseDto() {}

    public TransferRequestResponseDto(UUID guid, UUID fromInventoryGuid, UUID toInventoryGuid, UUID userGuid, UUID productGuid, Integer quantity, LocalDateTime createDate, String note) {
        this.guid = guid;
        this.fromInventoryGuid = fromInventoryGuid;
        this.toInventoryGuid = toInventoryGuid;
        this.userGuid = userGuid;
        this.productGuid = productGuid;
        this.quantity = quantity;
        this.createDate = createDate;
        this.note = note;
    }

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
