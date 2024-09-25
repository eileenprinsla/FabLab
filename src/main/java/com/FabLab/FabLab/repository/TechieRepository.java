package com.FabLab.FabLab.repository;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.entity.Techie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface TechieRepository extends JpaRepository<Techie, Integer> {

//    Techie FindByEmail(String email);
}

