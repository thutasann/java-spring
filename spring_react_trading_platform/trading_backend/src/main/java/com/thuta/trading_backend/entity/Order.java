package com.thuta.trading_backend.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.thuta.trading_backend.enums.ORDER_STATUS;
import com.thuta.trading_backend.enums.ORDER_TYPE;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

/**
 * Order Entity
 */
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private ORDER_TYPE orderType;

    @Column(nullable = false)
    private BigDecimal price;

    private LocalDateTime timestamp = LocalDateTime.now();

    @Column(nullable = false)
    private ORDER_STATUS status;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private OrderItem orderItem;
}
