package com.FabLab.FabLab.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechieController {

    @PostMapping("/techie/register")
    public void RegisterTechie() {

    }

    @PostMapping("/techie/authenticate")
    public void LoginTechie() {

    }
}
