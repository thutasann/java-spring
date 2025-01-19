package com.thuta.trading_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
