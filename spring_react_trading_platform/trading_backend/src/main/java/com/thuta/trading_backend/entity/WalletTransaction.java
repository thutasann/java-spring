package com.thuta.trading_backend.entity;

import java.time.LocalDate;

import com.thuta.trading_backend.enums.WALLET_TRANSACTION_TYPE;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Wallet Transaction Entity
 */
@Entity
@Data
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Wallet wallet;

    private WALLET_TRANSACTION_TYPE type;

    private LocalDate date;

    private String transferId;

    private String purpose;

    private Long amount;
}
