package com.springdataJpa.practise.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "adhaar",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uid_constraint",
                        columnNames = "uid"
                ),
                @UniqueConstraint(
                        name = "contact_constraint",
                        columnNames = "contactNo"
                )
        }
)
public class Adhaar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false,length = 12)
    private String uid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String permanentAddress;

    @Column(nullable = false)
    private LocalDate dob;
    private String gender;

    @Column(nullable = false)
    private String contactNo;

}
