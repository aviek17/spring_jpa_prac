package com.springdataJpa.practise.repository;

import com.springdataJpa.practise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
     public List<User> findByName(String name);

     public List <User> findByNameContaining(String name);


//     using JPQL ---> Java Persistence Query Language
     @Query("Select u from User u")
     public List<User> getAllUsers();


//     Using Native Query
     @Query(value = "Select name from user", nativeQuery = true)
     public List<String> getUserList();

     @Query(value = "select * from user u where u.name = :n", nativeQuery = true)
     public List<User> getUserByName(@Param("n") String name);

}
