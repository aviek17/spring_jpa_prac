package com.springdataJpa.practise.repository;

import com.springdataJpa.practise.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
