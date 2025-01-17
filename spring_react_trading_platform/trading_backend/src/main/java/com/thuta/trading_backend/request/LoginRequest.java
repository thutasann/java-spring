package com.thuta.trading_backend.request;

import com.thuta.trading_backend.entity.TwoFactorAuth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private Long id;

    private String email;

    private String password;

    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
}
