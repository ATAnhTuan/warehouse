package com.simsys.warehouse.requestdto;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionRequestDto {
    private BigDecimal money;
    private UUID customerGuid;
    private String description;

    public TransactionRequestDto(BigDecimal money, UUID customerGuid, String description) {
        this.money = money;
        this.customerGuid = customerGuid;
        this.description = description;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public UUID getCustomerGuid() {
        return customerGuid;
    }

    public void setCustomerGuid(UUID customerGuid) {
        this.customerGuid = customerGuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
