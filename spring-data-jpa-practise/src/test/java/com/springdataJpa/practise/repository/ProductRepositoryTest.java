package com.springdataJpa.practise.repository;

import com.springdataJpa.practise.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.*;


@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
//        first create a product object
        Product product = new Product();
        product.setActive(true);
        product.setName("Product 6");
        product.setProductCreated(LocalDateTime.now());
        product.setPrice(new BigDecimal("600.00"));
        product.setDescription("Product Six description");
        product.setProductLastUpdated(null);
        product.setSku("PRO106");
        product.setImgUrl("none.png");

//        save the data into the db
        Product savedProduct = productRepository.save(product);

//        display the data
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());

    }


    @Test
    void updateMethod(){
//        get the data from db
        Long id = 1L;
        Product product = productRepository.findById(id).get();
//        System.out.print("*******************************************-------------------------------.>>>>>>>>>>>>>>>>>>>>>\n"+product);

//        update the required info that need to be updated
        product.setName("Updated Product One Name");
        product.setDescription("Product One Updated description needs to be checked");
        product.setProductLastUpdated(LocalDateTime.now());

//        Save the updated entity in the db
        productRepository.save(product);
    }


    @Test
    void findProductById(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        System.out.println(product);
    }

    @Test
    void saveAllProducts(){
        Product product3 = new Product();
        product3.setActive(true);
        product3.setName("Product 3");
        product3.setProductCreated(LocalDateTime.now());
        product3.setPrice(new BigDecimal("100.00"));
        product3.setDescription("Product 3 description");
        product3.setProductLastUpdated(null);
        product3.setSku("PRO103");
        product3.setImgUrl("none.png");

        Product product4 = new Product();
        product4.setActive(true);
        product4.setName("Product 4");
        product4.setProductCreated(LocalDateTime.now());
        product4.setPrice(new BigDecimal("1040.00"));
        product4.setDescription("Product 4 description");
        product4.setProductLastUpdated(null);
        product4.setSku("PRO104");
        product4.setImgUrl("none.png");


        productRepository.saveAll(List.of(product3,product4));
    }

    @Test
    void findAllProduct(){
        List<Product> productList = productRepository.findAll();

        productList.forEach((item)->{
            System.out.println("Product name is "+item.getName());
        });
    }


    @Test
    void deleteProductById(){
        Long id = 3L;
        productRepository.deleteById(id);

    }
}