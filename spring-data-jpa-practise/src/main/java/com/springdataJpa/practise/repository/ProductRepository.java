package com.springdataJpa.practise.repository;

import com.springdataJpa.practise.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
