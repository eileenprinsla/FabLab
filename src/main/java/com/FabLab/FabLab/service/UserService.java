package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users CreateUser(Users user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        logger.info("User created with email:{}",user.getEmail());
        return userRepository.save(user);
    }


    public Users GetUser(int id) {

        return userRepository.findById(id).orElse(null);
    }

    public List<Users> GetAllUser() {

        return userRepository.findAll();
    }

    public Users UpdateEmail(int id, String email){

            Users user = userRepository.findById(id).orElse(null);
            user.setEmail(email);
            return userRepository.save(user);
    }

    public Users UpdatePassword(int id, String password){

        Users user = userRepository.findById(id).orElse(null);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public Users UpdateContact(int id, String contact){

        Users user = userRepository.findById(id).orElse(null);
        user.setContact(contact);
        return userRepository.save(user);
    }

    public Users UpdateName(int id, String name){

        Users user = userRepository.findById(id).orElse(null);
        user.setName(name);
        return userRepository.save(user);
    }

    public Users UpdateYear(int id, String year){

        Users user = userRepository.findById(id).orElse(null);
        user.setYear(year);
        return userRepository.save(user);
    }
}

