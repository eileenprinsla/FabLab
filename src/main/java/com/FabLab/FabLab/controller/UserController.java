package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.User;
import com.FabLab.FabLab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping("/RegisterUser")
    public ResponseEntity<String> CreateUser(@RequestBody User User){

        String response = UserService.CreateUser(User);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/DeleteUser")
    public  ResponseEntity<String> DeleteUser(@RequestParam int id){

        String response = UserService.DeleteUser(id);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/DeleteUserByName")
    public  ResponseEntity<String> DeleteUserByName(@RequestParam String name){

       String response = UserService.DeleteUserByName(name);

       return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/ReadUser")
    public ResponseEntity<User> ReadUser(@RequestParam int id){

        return ResponseEntity.ok(UserService.ReadUser(id));

    }

    @GetMapping("/ReadUserByName")
    public ResponseEntity<User> ReadUserByName(@RequestParam String name){

        return ResponseEntity.ok(UserService.ReadUserByName(name));

    }

}
