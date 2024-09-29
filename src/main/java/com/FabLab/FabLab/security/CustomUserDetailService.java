package com.FabLab.FabLab.security;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.repository.AdminRepository;
import com.FabLab.FabLab.repository.TechieRepository;
import com.FabLab.FabLab.repository.UserRepository;
import com.FabLab.FabLab.service.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final TechieRepository techieRepository;

    public CustomUserDetailService(UserRepository userRepository, AdminRepository adminRepository, TechieRepository techieRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.techieRepository = techieRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Check for Admin
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            return new UserPrincipal(admin);  // Create a UserPrincipal based on Admin
        }

        // If not Admin, check for Techie
        Techie techie = techieRepository.findByEmail(email);
        if (techie != null) {
            return new UserPrincipal(techie);  // Create a UserPrincipal based on Techie
        }

        // If not Techie, check for Users
        Users users = userRepository.findByEmail(email);
        if (users != null) {
            return new UserPrincipal(users);  // Create a UserPrincipal based on Users
        }

        // If no match found in any table, throw exception
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
