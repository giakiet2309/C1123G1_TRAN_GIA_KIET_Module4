package com.example.thim4p2.repository;

import com.example.thim4p2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduct extends JpaRepository<Product,Integer> {
}
