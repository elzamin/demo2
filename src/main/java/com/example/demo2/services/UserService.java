package com.example.demo2.services;

import com.example.demo2.models.User;
import com.example.demo2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user){
        User _user = userRepository.findById(userId).get();
        _user.setName(user.getName());
        _user.setEmail(user.getEmail());
        return userRepository.save(_user);
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
