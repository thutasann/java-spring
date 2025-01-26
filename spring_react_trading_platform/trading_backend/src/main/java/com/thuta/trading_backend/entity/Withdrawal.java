package com.thuta.trading_backend.entity;

import java.time.LocalDateTime;

import com.thuta.trading_backend.enums.WITHDRAWAL_STATUS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Withdrawal Entity
 */
@Data
@Entity
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private WITHDRAWAL_STATUS status;

    private Long amount;

    @ManyToOne
    private User user;

    private LocalDateTime date = LocalDateTime.now();
}
