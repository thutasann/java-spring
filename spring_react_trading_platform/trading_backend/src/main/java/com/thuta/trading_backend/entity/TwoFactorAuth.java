package com.thuta.trading_backend.entity;

import com.thuta.trading_backend.enums.VERIFICATION_TYPE;

import lombok.Data;

/**
 * Two Factor Authentication
 */
@Data
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VERIFICATION_TYPE sendTo;
}
