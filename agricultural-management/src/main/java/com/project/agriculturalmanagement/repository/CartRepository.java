package com.project.agriculturalmanagement.repository;


import com.project.agriculturalmanagement.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    public Cart findByCustomerId(long id);
}
