package com.springdataJpa.practise.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(
        name = "person",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "contactNo",
                        name = "person_contact_constraint"
                )
        }
)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false, unique = true, length = 10)
    private String contactNo;
    private String email;
    @Column(length = 100, nullable = false)
    private String currentAddress;
    private String maritalStatus;
    private String educationStatus;
    @Column(nullable = false)
    private LocalDateTime createdAt;
}
