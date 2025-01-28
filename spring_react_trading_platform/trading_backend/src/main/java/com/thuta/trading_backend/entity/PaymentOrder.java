package com.thuta.trading_backend.entity;

import com.thuta.trading_backend.enums.PAYMENT_METHOD;
import com.thuta.trading_backend.enums.PAYMENT_ORDER_STATUS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Payment Order Entity
 */
@Data
@Entity
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;

    private PAYMENT_ORDER_STATUS status;

    private PAYMENT_METHOD paymentMethod;

    @ManyToOne
    private User user;
}
