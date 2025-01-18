package com.thuta.trading_backend.request;

import com.thuta.trading_backend.enums.VERIFICATION_TYPE;

import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {
    private String sendTo;
    private VERIFICATION_TYPE verificationType;
}
