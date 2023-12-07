package com.project.agriculturalmanagement.repository;


import com.project.agriculturalmanagement.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    public List<Address> findByCustomerId(long id);
}
