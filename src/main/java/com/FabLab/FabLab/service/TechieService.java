package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Techie;

import com.FabLab.FabLab.repository.TechieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechieService {

    private final TechieRepository techieRepository;

    public TechieService(TechieRepository techieRepository) {
        this.techieRepository = techieRepository;
    }

    public Techie CreateAdmin(Techie techie) {
        return  techieRepository.save(techie);
    }

    public void fetchAssignedSlots(int id){


    }

}
