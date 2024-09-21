package com.FabLab.FabLab.security;

import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.entity.UserPrincipal;
import com.FabLab.FabLab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {


    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Users users = userRepository.FindByEmail(email);

        if (users == null) {
            throw new UsernameNotFoundException("User Not Found"+ email);
        }

        return new UserPrincipal(users);
    }
}
