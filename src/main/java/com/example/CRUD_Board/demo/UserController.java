package com.example.CRUD_Board.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test-db-connection")
    public String testDbConnection() {
        User user = new User();
        user.setName("Test User");
        userRepository.save(user);


        return "User saved with ID: " + user.getId();
    }
}