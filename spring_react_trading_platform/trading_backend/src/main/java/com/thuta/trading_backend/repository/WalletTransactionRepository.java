package com.thuta.trading_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.WalletTransaction;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {

}
