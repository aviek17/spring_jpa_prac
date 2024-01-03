package com.springdataJpa.practise.repository;

import com.springdataJpa.practise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
     public List<User> findByName(String name);

     public List <User> findByNameContaining(String name);
}
