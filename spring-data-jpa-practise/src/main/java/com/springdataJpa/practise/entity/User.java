package com.springdataJpa.practise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "user",
        schema = "Ecommerce"
)
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String city;
    private String status;


}
