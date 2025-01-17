package com.thuta.trading_backend.service.two_factor_otp;

import java.util.Optional;
import java.util.UUID;

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
        UUID uuid = UUID.randomUUID();

        TwoFactorOTP twoFactorOTP = new TwoFactorOTP();
        twoFactorOTP.setOtp(otp);
        twoFactorOTP.setJwt(jwt);
        twoFactorOTP.setId(uuid);
        twoFactorOTP.setUser(user);
        return twoFactorRepo.save(twoFactorOTP);
    }

    @Override
    public TwoFactorOTP findByUser(Long userId) {
        return twoFactorRepo.findByUserId(userId);
    }

    @Override
    public TwoFactorOTP findById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            Optional<TwoFactorOTP> otp = twoFactorRepo.findById(uuid);
            return otp.orElse(null);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOtp, String otp) {
        return twoFactorOtp.getOtp().equals(otp);
    }

    @Override
    public void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP) {
        twoFactorRepo.delete(twoFactorOTP);
    }
}
