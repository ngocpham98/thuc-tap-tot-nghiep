package com.project.agriculturalmanagement.repository;

import com.project.agriculturalmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer,Long> {
    public Customer findByUsername(String username);
}
