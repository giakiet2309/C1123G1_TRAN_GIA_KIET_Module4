package com.blog.repository;

import com.blog.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Categories, Integer> {
}
