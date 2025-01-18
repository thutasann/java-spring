package com.thuta.trading_backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.ForgotPasswordToken;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken, UUID> {
    ForgotPasswordToken findByUserId(Long userId);
}
