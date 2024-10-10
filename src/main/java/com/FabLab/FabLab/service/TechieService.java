package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.repository.TechieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TechieService {

    private final TechieRepository techieRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public TechieService(TechieRepository techieRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.techieRepository = techieRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    public Techie CreateAdmin(Techie techie) {
        String hashedPassword = passwordEncoder.encode(techie.getPassword());
        techie.setPassword(hashedPassword);
        return   techieRepository.save(techie);
    }

    public List<Techie> GetAllTechie() {

        return techieRepository.findAll();
    }

    public Techie UpdateEmail(int id, String email){

        Techie techie = techieRepository.findById(id).orElse(null);
        techie.setEmail(email);
        return techieRepository.save(techie);
    }

    public Techie UpdatePassword(int id, String password){

        Techie techie = techieRepository.findById(id).orElse(null);
        techie.setPassword(password);
        return techieRepository.save(techie);
    }

    public Techie UpdateName(int id, String name){

        Techie techie = techieRepository.findById(id).orElse(null);
        techie.setName(name);
        return techieRepository.save(techie);
    }

}
