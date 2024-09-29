package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users CreateUser(Users user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public void UpdateUser(Users user) {

        userRepository.save(user);
    }

    public void DeleteUser(String email) {

    }

    public void GetUser(int id) {

        userRepository.findById(id);
    }
}

