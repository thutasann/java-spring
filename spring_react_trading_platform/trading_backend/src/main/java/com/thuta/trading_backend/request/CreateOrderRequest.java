package com.thuta.trading_backend.request;

import com.thuta.trading_backend.enums.ORDER_TYPE;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private String coinId;
    private double quantity;
    private ORDER_TYPE orderType;
}
