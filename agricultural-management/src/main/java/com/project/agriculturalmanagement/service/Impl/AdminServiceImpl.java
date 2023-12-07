package com.project.agriculturalmanagement.service.Impl;

import com.project.agriculturalmanagement.dto.AdminDto;
import com.project.agriculturalmanagement.entity.Admin;
import com.project.agriculturalmanagement.repository.AdminRepository;
import com.project.agriculturalmanagement.repository.RoleRepository;
import com.project.agriculturalmanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Admin findByUserName(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin addAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setRole(roleRepository.findByName("ADMIN"));
        return adminRepository.save(admin);
    }
}
