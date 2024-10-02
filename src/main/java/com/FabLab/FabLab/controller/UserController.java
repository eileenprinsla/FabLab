package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public Users RegisterUser(@RequestBody Users user) {

        return userService.CreateUser(user);
    }

    @GetMapping("/user/read/{id}")
    public ResponseEntity<Users> ReadUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.GetUser(id));
    }


    @GetMapping("/user/read/all")
    public ResponseEntity<List<Users>> ReadAllUser() {

        List<Users> allUsers = userService.GetAllUser();
        return ResponseEntity.ok(allUsers);
    }

    @PutMapping("user/update/email/{id}")
    public ResponseEntity<Users> UpdateUserEmail(@PathVariable int id,@RequestBody String email){

        Users user = userService.UpdateEmail(id, email);
        return ResponseEntity.ok(user);
    }

    @PutMapping("user/update/password/{id}")
    public ResponseEntity<Users> UpdateUserPassword(@PathVariable int id,@RequestBody String password){

        Users user = userService.UpdatePassword(id, password);
        return ResponseEntity.ok(user);
    }

    @PutMapping("user/update/contact/{id}")
    public ResponseEntity<Users> UpdateUserContact(@PathVariable int id,@RequestBody String contact){

        Users user = userService.UpdateContact(id, contact);
        return ResponseEntity.ok(user);
    }

    @PutMapping("user/update/name/{id}")
    public ResponseEntity<Users> UpdateUserName(@PathVariable int id,@RequestBody String name){

        Users user = userService.UpdateName(id, name);
        return ResponseEntity.ok(user);
    }

    @PutMapping("user/update/year/{id}")
    public ResponseEntity<Users> UpdateUserYear(@PathVariable int id,@RequestBody String year){

        Users user = userService.UpdateYear(id,year);
        return ResponseEntity.ok(user);
    }

}
