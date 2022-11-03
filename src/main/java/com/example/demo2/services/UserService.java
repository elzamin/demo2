package com.example.demo2.services;

import com.example.demo2.models.User;
import com.example.demo2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveOrUpdateProject(User user){
        return userRepository.save(user);
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long userId){
        return userRepository.findById(userId).get();
    }

    public void deleteUserById (Long userId){
        userRepository.deleteById(userId);
    }
}
