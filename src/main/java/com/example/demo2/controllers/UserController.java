package com.example.demo2.controllers;

import com.example.demo2.models.User;
import com.example.demo2.repositories.UserRepository;
import com.example.demo2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> createNewUser (@RequestBody User user){
        User user1 = userService.saveOrUpdateProject(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
    @GetMapping("hi")
    public String hi() {
        return "Hello";
    }
}
