package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {

    private UserService userService;

    @PostMapping("/user/register")
    public void RegisterUser(@RequestBody Users user) {

        userService.CreateUser(user);
    }

    @PostMapping("user/login")
    public void LoginUser(@RequestBody String email, String password) {

        userService.LoginUser(email, password);
    }

    @GetMapping("/user/read/{id}")
    public void ReadUser(@PathVariable int id) {

        userService.GetUser(id);
    }

    @DeleteMapping("/user/delete/{email}")
    public void DeleteUser(@PathVariable String email) {

        userService.DeleteUser(email);
    }

}
