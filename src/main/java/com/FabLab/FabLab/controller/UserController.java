package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {

    private UserService userService;

    @PostMapping("/user/register")
    public Users RegisterUser(@RequestBody Users user) {
        return userService.CreateUser(user);
    }

    @GetMapping("/user/read/{id}")
    public void ReadUser(@PathVariable int id) {

        userService.GetUser(id);
    }

}
