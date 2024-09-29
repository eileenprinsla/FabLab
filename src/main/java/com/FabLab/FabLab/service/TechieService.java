package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.repository.TechieRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

}
