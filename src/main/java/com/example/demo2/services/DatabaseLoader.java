package com.example.demo2.services;

import com.example.demo2.models.User;
import com.example.demo2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.save(new User("Vitya", "victor@mail.ru"));
        this.userRepository.save(new User("Ida", "ida@gmail.com"));
    }
}
