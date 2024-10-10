package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.service.TechieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/techie/update/email/{id}")
    public ResponseEntity<Techie> UpdateTechieEmail(@PathVariable int id,@RequestBody String email){

        Techie techie = techieService.UpdateEmail(id, email);
        return ResponseEntity.ok(techie);
    }

    @PutMapping("/techie/update/password/{id}")
    public ResponseEntity<Techie> UpdateTechiePassword(@PathVariable int id,@RequestBody String password){

        Techie techie = techieService.UpdatePassword(id, password);
        return ResponseEntity.ok(techie);
    }

    @PutMapping("/techie/update/name/{id}")
    public ResponseEntity<Techie> UpdateTechieName(@PathVariable int id,@RequestBody String name){

        Techie techie = techieService.UpdateName(id, name);
        return ResponseEntity.ok(techie);
    }


}
