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

}
