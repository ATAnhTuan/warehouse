package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @Column(name = "customer_guid", nullable = false)
    private UUID customerGuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_guid", referencedColumnName = "guid", insertable = false, updatable = false)
    private CustomerEntity customer;

    @Column(name = "transaction_guid")
    private UUID transactionGuid;

    @Column
    private String description;

    @Column
    private Integer totalPrice;

    @Column
    private String isActive;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderDetailEntity> orderDetails = new ArrayList<>();

    public OrderEntity() {
    }



    public OrderEntity(UUID customerGuid, String description, Integer totalPrice, String isActive) {
        this.customerGuid = customerGuid;
        this.description = description;
        this.totalPrice = totalPrice;
        this.isActive = isActive;
    }

    public OrderEntity(UUID guid, UUID customerGuid, CustomerEntity customer, UUID transactionGuid, String description, Integer totalPrice, String isActive, List<OrderDetailEntity> orderDetails) {
        this.guid = guid;
        this.customerGuid = customerGuid;
        this.customer = customer;
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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
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

    public List<OrderDetailEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
