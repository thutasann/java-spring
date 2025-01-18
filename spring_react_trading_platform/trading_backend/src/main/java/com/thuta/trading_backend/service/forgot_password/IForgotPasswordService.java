package com.thuta.trading_backend.service.forgot_password;

import java.util.List;

import com.thuta.trading_backend.entity.ForgotPasswordToken;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.VERIFICATION_TYPE;

public interface IForgotPasswordService {

    List<ForgotPasswordToken> findAll();

    ForgotPasswordToken createToken(
            User user, String otp,
            VERIFICATION_TYPE verificationType,
            String sendTo);

    ForgotPasswordToken findById(String id) throws Exception;

    ForgotPasswordToken findByUserId(Long userId) throws Exception;

    void deleteToken(ForgotPasswordToken token);
}
