package com.thuta.trading_backend.entity;

import java.util.UUID;

import com.thuta.trading_backend.enums.VERIFICATION_TYPE;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

/**
 * Forgot Password Token Entity
 */
@Entity
@Data
public class ForgotPasswordToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private User user;

    private String otp;

    private VERIFICATION_TYPE verificationType;

    private String sendTo;
}
