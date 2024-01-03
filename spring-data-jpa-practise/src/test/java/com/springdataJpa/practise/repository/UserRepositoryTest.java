package com.springdataJpa.practise.repository;


import com.springdataJpa.practise.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Test
    public void createUser(){
        User user = new User();
        user.setName("Aviek Paul");
        user.setCity("Kolkata");
        user.setStatus("Active");

        User savedUser = userRepo.save(user);
        System.out.println(savedUser);
    }

    @Test
    public void updateUSer(){
        int id = 1;
        User user = userRepo.findById(id).get();

        user.setName("Aviek Paul");
        user.setStatus("active");

        User savedUser = userRepo.save(user);
        System.out.println(savedUser);
    }

    @Test
    public void deleteUserById(){
        int id = 2;
        userRepo.deleteById(id);
    }

    @Test
    public void getUserList(){
        List<User> userList = userRepo.findAll();

        userList.forEach(((item)->{
            System.out.println(item.getName() + " is the name, living in " + item.getCity());
        }));
    }

    @Test
    public void findUserByName(){
        String name = "Aviek";
        List <User> userList = userRepo.findByName(name);

        userList.forEach((item)->{
            System.out.println("My name is "+ item.getName() + " and my status is " + item.getStatus());
        });

        userList = userRepo.findByNameContaining(name);

        userList.forEach((item)->{
            System.out.println("My name is "+ item.getName() + " and my status is " + item.getStatus());
        });
    }

}
