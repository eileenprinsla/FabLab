package com.FabLab.FabLab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String checkHealth(){
        return "Application up and running on port 8080";
    }

}
