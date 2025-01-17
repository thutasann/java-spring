package com.thuta.trading_backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuta.trading_backend.entity.TwoFactorOTP;

public interface TwoFactorOtpRepository extends JpaRepository<TwoFactorOTP, UUID> {
    TwoFactorOTP findByUserId(Long userId);
}
