package com.springdataJpa.practise.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(
        name = "book",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "isbn_constraints",
                        columnNames = "isbn"
                )
        }
)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    private String description;
    private String category;
    @Column(nullable = false)
    private Date publicationYear;
    private String publisher;
    @Column(unique = true, nullable = false)
    private String isbn;
    @Column(nullable = false)
    private String language;
    @Column(nullable = true)
    private LocalDateTime createdAt;
    @Column(nullable = true)
    private  LocalDateTime updatedAt;
    private String price;
    private Double rating;
    private String imgUrl;

}
