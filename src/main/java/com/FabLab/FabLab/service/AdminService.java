package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    @Autowired
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public  void CreateAdmin(Admin admin){
        adminRepository.save(admin);
    }

    public  void LoginAdmin(String email, String Password){
//        /
    }

}
