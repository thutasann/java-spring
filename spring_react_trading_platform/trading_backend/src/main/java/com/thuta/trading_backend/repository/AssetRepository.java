package com.thuta.trading_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}
