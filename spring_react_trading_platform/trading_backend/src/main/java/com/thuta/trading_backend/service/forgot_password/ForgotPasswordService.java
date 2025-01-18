package com.thuta.trading_backend.service.forgot_password;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.ForgotPasswordToken;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.VERIFICATION_TYPE;
import com.thuta.trading_backend.repository.ForgotPasswordRepository;

@Service
public class ForgotPasswordService implements IForgotPasswordService {

    @Autowired
    private ForgotPasswordRepository forgotPasswordRepo;

    @Override
    public ForgotPasswordToken createToken(
            User user,
            String otp,
            VERIFICATION_TYPE verificationType,
            String sendTo) {
        ForgotPasswordToken token = new ForgotPasswordToken();
        token.setUser(user);
        token.setSendTo(sendTo);
        token.setVerificationType(verificationType);
        token.setOtp(otp);
        return forgotPasswordRepo.save(token);
    }

    @Override
    public ForgotPasswordToken findById(String id) throws Exception {
        UUID uuid = UUID.fromString(id);
        Optional<ForgotPasswordToken> token = forgotPasswordRepo.findById(uuid);
        if (token.isEmpty()) {
            throw new Exception("Forgot Password Token is not found with this Id " + id);
        }
        return token.get();
    }

    @Override
    public ForgotPasswordToken findByUserId(Long userId) throws Exception {
        return forgotPasswordRepo.findByUserId(userId);
    }

    @Override
    public void deleteToken(ForgotPasswordToken token) {
        forgotPasswordRepo.delete(token);
    }

    @Override
    public List<ForgotPasswordToken> findAll() {
        return forgotPasswordRepo.findAll();
    }
}
