package com.thuta.trading_backend.service.auth;

import com.thuta.trading_backend.entity.User;

public interface IAuthService {
    User register(User user) throws Exception;
}
