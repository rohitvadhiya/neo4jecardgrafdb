package com.neo4j.ecard.controller;

import com.neo4j.ecard.entity.User;
import com.neo4j.ecard.payload.UserRequest;
import com.neo4j.ecard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/getall")
    public List<User> getAll()
    {
        return userService.getAllUser();
    }
}
