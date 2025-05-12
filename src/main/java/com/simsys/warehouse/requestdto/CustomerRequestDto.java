package com.simsys.warehouse.requestdto;

public class CustomerRequestDto {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String bankCard;


    public CustomerRequestDto(String name, String phone, String email, String address, String bankCard) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.bankCard = bankCard;
    }

    public CustomerRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }
}
