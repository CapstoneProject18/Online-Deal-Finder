package com.springboot.onlinedealfinder.repository;

import com.springboot.onlinedealfinder.model.SellerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerHistoryRepository extends JpaRepository<SellerHistory, Long> {
}
