package com.springboot.onlinedealfinder.repository;

import com.springboot.onlinedealfinder.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    public Buyer findByEmail(@Param("email") String email);

}
