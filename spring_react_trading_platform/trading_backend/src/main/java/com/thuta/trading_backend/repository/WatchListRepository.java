package com.thuta.trading_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.WatchList;

public interface WatchListRepository extends JpaRepository<WatchList, Long> {
    WatchList findByUserId(Long userId);
}
