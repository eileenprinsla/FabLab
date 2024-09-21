package com.FabLab.FabLab.repository;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users FindByEmail(String email);
}