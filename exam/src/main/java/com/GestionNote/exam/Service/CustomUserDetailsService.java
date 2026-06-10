package com.GestionNote.exam.Service;

import com.GestionNote.exam.Entity.Oracle.Users;

import com.GestionNote.exam.Repository.Oracle.userRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailsService implements UserDetailsService {

    private final userRepository repo;


    public CustomUserDetailsService(userRepository repo) {
        this.repo = repo;
    }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Users user = repo.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username)
                );

        return new CustomUserDetails(user);
    }
}