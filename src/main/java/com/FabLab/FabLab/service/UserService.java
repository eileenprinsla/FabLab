package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.User;
import com.FabLab.FabLab.repository.UserRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public String CreateUser(User User){

        UserRepository.save(User);

        return "User registered successfully";
    }

    public String DeleteUser(int id){

        Optional<User> user = UserRepository.findById(id);

        if (user.isPresent()) {
            var userDetails = user.get();
            UserRepository.delete(userDetails);
            return "User removed successfully";
        }

        return  "";
    }

    @Transactional
    public String DeleteUserByName(String name){

        UserRepository.DeleteByName(name);

        return "User removed successfully";
    }

    public User ReadUser(int id){

         return UserRepository.findById(id).orElse(null);

    }

    public User ReadUserByName(String name){

        return UserRepository.ReadByName(name);

    }

}
