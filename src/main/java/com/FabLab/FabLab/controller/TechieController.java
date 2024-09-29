package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.service.TechieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechieController {

    private final TechieService techieService;

    public TechieController(TechieService techieService) {
        this.techieService = techieService;
    }
    @PostMapping("/techie/register")
    public Techie RegisterTechie(@RequestBody Techie techie) {
       return techieService.CreateAdmin(techie);
    }
}
