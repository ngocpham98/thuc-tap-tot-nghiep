package com.project.agriculturalmanagement.repository;

import com.project.agriculturalmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByCustomerId(long customerId);
}
