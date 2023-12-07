package com.project.agriculturalmanagement.service;

import com.project.agriculturalmanagement.dto.CustomerDto;
import com.project.agriculturalmanagement.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

public interface CustomerService {
    public Customer findByUsername(String username);
    public Customer createAccount (CustomerDto customerDto);
    public Customer updateInfo(MultipartFile image, CustomerDto customerDto);
    public CustomerDto toDto(Customer customer);
}
