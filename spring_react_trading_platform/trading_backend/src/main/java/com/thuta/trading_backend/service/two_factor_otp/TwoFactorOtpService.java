package com.thuta.trading_backend.service.two_factor_otp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.TwoFactorOTP;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.repository.TwoFactorOtpRepository;

@Service
public class TwoFactorOtpService implements ITwoFactorOtpService {

    @Autowired
    private TwoFactorOtpRepository twoFactorRepo;

    @Override
    public TwoFactorOTP createTwoFactorOtp(User user, String otp, String jwt) {
        throw new UnsupportedOperationException("Unimplemented method 'createTwoFactorOtp'");
    }

    @Override
    public TwoFactorOTP findByUser(Long userId) {
        throw new UnsupportedOperationException("Unimplemented method 'findByUser'");
    }

    @Override
    public TwoFactorOTP findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOtp, String otp) {
        throw new UnsupportedOperationException("Unimplemented method 'verifyTwoFactorOtp'");
    }

    @Override
    public void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteTwoFactorOtp'");
    }
}
