package com.thuta.trading_backend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OTPVerifyRequest {
    private String otp;

    private String id;
}
