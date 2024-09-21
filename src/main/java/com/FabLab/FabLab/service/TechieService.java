package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.repository.AdminRepository;
import com.FabLab.FabLab.repository.TechieRepository;
import org.springframework.stereotype.Service;

@Service
public class TechieService {

    private TechieRepository techieRepository;

    public  void CreateAdmin(Techie techie){
        techieRepository.save(techie);
    }

    public  void LoginAdmin(String email, String Password){
        Techie techie = techieRepository.FindByEmail(email);
    }
}
