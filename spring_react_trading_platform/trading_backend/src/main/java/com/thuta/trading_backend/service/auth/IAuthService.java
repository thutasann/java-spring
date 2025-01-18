package com.thuta.trading_backend.service.auth;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.request.LoginRequest;
import com.thuta.trading_backend.response.AuthResponse;

public interface IAuthService {
    AuthResponse register(User user) throws Exception;

    AuthResponse signIn(LoginRequest request) throws Exception;

    AuthResponse verifySignInOtp(String otp, String id) throws Exception;
}
