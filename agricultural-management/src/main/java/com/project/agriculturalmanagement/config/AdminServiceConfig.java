package com.project.agriculturalmanagement.config;

import com.project.agriculturalmanagement.entity.Admin;
import com.project.agriculturalmanagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AdminServiceConfig implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Admin admin = adminRepository.findByUsername(username);
         if(admin == null) throw new UsernameNotFoundException("Could not find username");
        return new User(admin.getUsername(),admin.getPassword(),admin.getAuthorities());
    }
}
