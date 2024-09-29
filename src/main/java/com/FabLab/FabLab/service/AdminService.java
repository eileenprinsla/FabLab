package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.repository.AdminRepository;
import com.FabLab.FabLab.security.CustomUserDetailService;
import com.FabLab.FabLab.security.JwtService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final CustomUserDetailService customUserDetailService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AdminService(AdminRepository adminRepository, CustomUserDetailService customUserDetailService, BCryptPasswordEncoder passwordEncoder, JwtService jwtService) {
        this.adminRepository = adminRepository;
        this.customUserDetailService = customUserDetailService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public Admin CreateAdmin(Admin admin){
        String hashedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(hashedPassword);
        return adminRepository.save(admin);
    }

    public String LoginAdmin(String email, String Password){
       var users = customUserDetailService.loadUserByUsername(email);

       if (users == null){
           throw new UsernameNotFoundException("User not found");
       }

       String exPassword = users.getPassword();
       if (passwordEncoder.matches(Password, exPassword)) {
           Map<String, Object> claims = new HashMap<>();
           claims.put("username" , users.getUsername());
           claims.put("email", email);
           claims.put("role", users.getAuthorities());
           long currentTimeMillis = System.currentTimeMillis();
           claims.put("iat", new Date(currentTimeMillis));  // Issued at time
           claims.put("exp", new Date(currentTimeMillis + jwtService.getExpirationTime()));
           return jwtService.generateToken(claims , users);
       }
       else {
           throw new UsernameNotFoundException("Invalid Credentials");
       }
    }

}
