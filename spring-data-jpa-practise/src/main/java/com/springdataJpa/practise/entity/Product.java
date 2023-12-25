package com.springdataJpa.practise.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(
        name = "products",
        schema = "Ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_constraints",
                        columnNames = "stock_keeping_unit"
                )
        }
)
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long Id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;
    private String description;

    @Column(nullable = false)
    private BigDecimal price;
    private boolean active;
    private String imgUrl;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime productCreated;

    @UpdateTimestamp
    private LocalDateTime productLastUpdated;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDateTime getProductCreated() {
        return productCreated;
    }

    public void setProductCreated(LocalDateTime productCreated) {
        this.productCreated = productCreated;
    }

    public LocalDateTime getProductLastUpdated() {
        return productLastUpdated;
    }

    public void setProductLastUpdated(LocalDateTime productLastUpdated) {
        this.productLastUpdated = productLastUpdated;
    }


}
