package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @Column(nullable = false)
    private BigDecimal money;

    private String description;

    @Column(nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "customer_guid", nullable = false)
    private UUID customerGuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_guid", referencedColumnName = "guid", insertable = false, updatable = false)
    private CustomerEntity customer;


    public TransactionEntity() {
    }

    public TransactionEntity(BigDecimal money, String description, LocalDateTime createDate, UUID customerGuid, CustomerEntity customer, UUID guid) {
        this.money = money;
        this.description = description;
        this.createDate = createDate;
        this.customerGuid = customerGuid;
        this.customer = customer;
        this.guid = guid;
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

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
