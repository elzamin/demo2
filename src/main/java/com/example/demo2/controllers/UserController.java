package com.example.demo2.controllers;

import com.example.demo2.models.User;
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

    @GetMapping("/all")
    public Iterable<User> getAll(){
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        User user = userService.findUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
        return new ResponseEntity<String>("User with ID "+ userId+" deleted",HttpStatus.OK);
    }
}
