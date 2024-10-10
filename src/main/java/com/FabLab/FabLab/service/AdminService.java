package com.FabLab.FabLab.service;


import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.repository.AdminRepository;
import org.springframework.stereotype.Service;



@Service
public class AdminService {

    private final AdminRepository adminRepository;


    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin CreateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public String LoginAdmin(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);

        if (admin == null) {
            return "Admin not found";
        }

        if (admin.getPassword().equals(password)) {
            return "Valid";
        }
        return "Invalid password";
    }
}


