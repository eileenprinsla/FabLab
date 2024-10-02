package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.service.TechieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/techie/read/all")
    public ResponseEntity<List<Techie>> ReadAllTechie(){

        List<Techie> allTechie = techieService.GetAllTechie();
        return ResponseEntity.ok(allTechie);
    }
}
