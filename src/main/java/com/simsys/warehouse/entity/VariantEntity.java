package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "variants")
public class VariantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private String size;

    @Column(nullable = false, unique = true)
    private UUID guid = UUID.randomUUID();

    @OneToMany(mappedBy = "variant", fetch = FetchType.LAZY)
    private List<ProductEntity> products;

    public VariantEntity() {
    }

    public VariantEntity(String color, String size, UUID guid, List<ProductEntity> products) {
        this.color = color;
        this.size = size;
        this.guid = guid;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
