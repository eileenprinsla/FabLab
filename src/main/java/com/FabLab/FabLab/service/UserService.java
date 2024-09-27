package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void CreateUser(Users user) {

        userRepository.save(user);
    }

    public void LoginUser(String email, String password) {

//        Users user = userRepository.FindByEmail(email);
    }

    public void UpdateUser(Users user) {

        userRepository.save(user);
    }

    public void DeleteUser(String email) {

//        Users user = userRepository.FindByEmail(email);
//
//        userRepository.delete(user);
    }

    public void GetUser(int id) {

        userRepository.findById(id);
    }
}

