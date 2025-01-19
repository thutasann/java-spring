package com.thuta.trading_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByUserId(Long userId);
}
