package com.springdataJpa.practise.entity;

import jakarta.persistence.*;
import lombok.*;
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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

}
