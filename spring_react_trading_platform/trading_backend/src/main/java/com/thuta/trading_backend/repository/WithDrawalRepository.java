package com.thuta.trading_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.Withdrawal;

public interface WithDrawalRepository extends JpaRepository<Withdrawal, Long> {
    List<Withdrawal> findByUserId(Long userId);
}
