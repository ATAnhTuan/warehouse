package com.simsys.warehouse.responsedto;

import java.util.List;
import java.util.UUID;

public class OrderResponseDto {
    private Long id;
    private UUID guid;
    private UUID customerGuid;
    private UUID transactionGuid;
    private String description;
    private Integer totalPrice;
    private String isActive;
    private List<OrderDetailResponseDto> orderDetails;

    public OrderResponseDto(Long id, UUID guid, UUID customerGuid, UUID transactionGuid,
                            String description, Integer totalPrice, String isActive,
                            List<OrderDetailResponseDto> orderDetails) {
        this.id = id;
        this.guid = guid;
        this.customerGuid = customerGuid;
        this.transactionGuid = transactionGuid;
        this.description = description;
        this.totalPrice = totalPrice;
        this.isActive = isActive;
        this.orderDetails = orderDetails;
    }

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

    public UUID getCustomerGuid() {
        return customerGuid;
    }

    public void setCustomerGuid(UUID customerGuid) {
        this.customerGuid = customerGuid;
    }

    public UUID getTransactionGuid() {
        return transactionGuid;
    }

    public void setTransactionGuid(UUID transactionGuid) {
        this.transactionGuid = transactionGuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public List<OrderDetailResponseDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailResponseDto> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
