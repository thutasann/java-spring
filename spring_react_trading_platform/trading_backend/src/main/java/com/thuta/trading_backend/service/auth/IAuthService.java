package com.thuta.trading_backend.service.auth;

import com.thuta.trading_backend.entity.User;

public interface IAuthService {
    String register(User user) throws Exception;
}
