package com.springboot.onlinedealfinder.repository;

import com.springboot.onlinedealfinder.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Id;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByProductName(@Param("productName") String productName);
}
