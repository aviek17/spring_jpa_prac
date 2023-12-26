package com.springdataJpa.practise.repository;

import com.springdataJpa.practise.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
//        first create a product object
        Product product = new Product();
        product.setActive(true);
        product.setName("Product 1");
        product.setProductCreated(LocalDateTime.now());
        product.setPrice(new BigDecimal("100.00"));
        product.setDescription("Product description");
        product.setProductLastUpdated(null);
        product.setSku("PRO100");
        product.setImgUrl("none.png");

//        save the data into the db
        Product savedProduct = productRepository.save(product);

//        display the data
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());

    }
}