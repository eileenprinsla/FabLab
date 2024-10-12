package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users CreateUser(Users user) {
        logger.info("User created with email:{}",user.getEmail());
        return userRepository.save(user);
    }


    public Users GetUser(int id) {

        return userRepository.findById(id).orElse(null);
    }


}

