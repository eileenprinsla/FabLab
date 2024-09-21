package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    public  void CreateAdmin(Admin admin){
        adminRepository.save(admin);
    }

    public  void LoginAdmin(String email, String Password){
        Admin admin = adminRepository.FindByEmail(email);
    }

}
