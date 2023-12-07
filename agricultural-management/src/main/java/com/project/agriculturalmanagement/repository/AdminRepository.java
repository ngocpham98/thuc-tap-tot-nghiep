package com.project.agriculturalmanagement.repository;


import com.project.agriculturalmanagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    public Admin findByUsername(String username);
}
