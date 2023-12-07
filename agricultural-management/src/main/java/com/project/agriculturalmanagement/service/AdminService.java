package com.project.agriculturalmanagement.service;


import com.project.agriculturalmanagement.dto.AdminDto;
import com.project.agriculturalmanagement.entity.Admin;

public interface AdminService {
    public Admin findByUserName(String username);
    public Admin addAdmin(AdminDto adminDto);
}
