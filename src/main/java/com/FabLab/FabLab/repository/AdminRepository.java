package com.FabLab.FabLab.repository;

import com.FabLab.FabLab.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin, Integer> {

//    Admin FindByEmail(String email);
}
