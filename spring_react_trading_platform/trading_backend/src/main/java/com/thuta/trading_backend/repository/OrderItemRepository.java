package com.thuta.trading_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
