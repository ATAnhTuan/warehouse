package com.simsys.warehouse.responsedto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionResponseDto {
    private final Long id;
    private final UUID guid;
    private final BigDecimal money;
    private final LocalDateTime createDate;
    private final UUID customerGuid;
    private final String description; // mới thêm

    public TransactionResponseDto(Long id, UUID guid, BigDecimal money, LocalDateTime createDate, UUID customerGuid, String description) {
        this.id = id;
        this.guid = guid;
        this.money = money;
        this.createDate = createDate;
        this.customerGuid = customerGuid;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public UUID getGuid() {
        return guid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public UUID getCustomerGuid() {
        return customerGuid;
    }

    public String getDescription() {
        return description;
    }
}
