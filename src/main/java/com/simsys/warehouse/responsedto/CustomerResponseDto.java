package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class CustomerResponseDto {
    private final Long id;
    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final String bankCard;
    private final UUID guid;

    public CustomerResponseDto(Long id, String name, String phone, String email, String address, String bankCard, UUID guid) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.bankCard = bankCard;
        this.guid = guid;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getBankCard() {
        return bankCard;
    }

    public UUID getGuid() {
        return guid;
    }
}
