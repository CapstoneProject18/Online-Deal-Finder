package com.springboot.onlinedealfinder.repository;

import com.springboot.onlinedealfinder.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    public Seller findByName (@Param("name") String name);
}
