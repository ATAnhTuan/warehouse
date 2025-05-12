package com.simsys.warehouse.requestdto;

import java.util.UUID;

public class TransferRequestRequestDto {
    private UUID fromInventoryGuid;
    private UUID toInventoryGuid;
    private UUID userGuid;
    private UUID productGuid;
    private Integer quantity;
    private String note;

    public TransferRequestRequestDto() {}

    public TransferRequestRequestDto(UUID fromInventoryGuid, UUID toInventoryGuid, UUID userGuid, UUID productGuid, Integer quantity, String note) {
        this.fromInventoryGuid = fromInventoryGuid;
        this.toInventoryGuid = toInventoryGuid;
        this.userGuid = userGuid;
        this.productGuid = productGuid;
        this.quantity = quantity;
        this.note = note;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
