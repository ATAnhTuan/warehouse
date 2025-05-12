package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @Column(nullable = false)
    private String name;

    private String phone;

    private String email;

    private String address;

    @Column(name = "bank_card")
    private String bankCard;

    // OneToMany relationship
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions;

    public CustomerEntity() {
    }

    public CustomerEntity(String name, UUID guid, String phone, String email, String address, String bankCard) {
        this.name = name;
        this.guid = guid;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.bankCard = bankCard;
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

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }
}
