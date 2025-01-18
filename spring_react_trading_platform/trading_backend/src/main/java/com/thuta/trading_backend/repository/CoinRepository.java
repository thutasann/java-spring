package com.thuta.trading_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.Coin;

public interface CoinRepository extends JpaRepository<Coin, String> {

}
