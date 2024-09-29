package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private String username;
    private String password;
    private String role;

    // Constructor for Admin
    public UserPrincipal(Admin admin) {
        this.username = admin.getName();
        this.password = admin.getPassword();  // Assuming Admin has a password field
        this.role = "ADMIN";
    }

    // Constructor for Techie
    public UserPrincipal(Techie techie) {
        this.username = techie.getName();
        this.password = techie.getPassword();  // Assuming Techie has a password field
        this.role = "TECHIE";
    }

    // Constructor for Users
    public UserPrincipal(Users users) {
        this.username = users.getName();
        this.password = users.getPassword();
        this.role = "USER";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
