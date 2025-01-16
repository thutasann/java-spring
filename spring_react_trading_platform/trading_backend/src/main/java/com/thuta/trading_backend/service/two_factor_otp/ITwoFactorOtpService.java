package com.thuta.trading_backend.service.two_factor_otp;

import com.thuta.trading_backend.entity.TwoFactorOTP;
import com.thuta.trading_backend.entity.User;

public interface ITwoFactorOtpService {
    TwoFactorOTP createTwoFactorOtp(User user, String otp, String jwt);

    TwoFactorOTP findByUser(Long userId);

    TwoFactorOTP findById(String id);

    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOtp, String otp);

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);
}
