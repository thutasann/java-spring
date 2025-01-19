package com.thuta.trading_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
