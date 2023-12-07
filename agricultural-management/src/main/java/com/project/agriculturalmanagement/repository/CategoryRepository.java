package com.project.agriculturalmanagement.repository;


import com.project.agriculturalmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT p from Category p where p.name like %?1%")
    public List<Category> searchCategory(String keyword);

}
