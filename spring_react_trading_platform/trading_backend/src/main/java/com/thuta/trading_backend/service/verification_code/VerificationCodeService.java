package com.thuta.trading_backend.service.verification_code;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.VerificationCode;
import com.thuta.trading_backend.enums.VERIFICATION_TYPE;
import com.thuta.trading_backend.repository.VerificationCodeRepository;
import com.thuta.trading_backend.util.OtpUtils;

@Service
public class VerificationCodeService implements IVerificationCodeService {

    @Autowired
    private VerificationCodeRepository verificationCodeRepo;

    @Override
    public VerificationCode createVerificationCode(User user, VERIFICATION_TYPE verificationType) throws Exception {
        VerificationCode verificationCode = new VerificationCode();
        verificationCode.setOtp(OtpUtils.generateOTP());
        verificationCode.setVerificationType(verificationType);
        verificationCode.setUser(user);
        return verificationCodeRepo.save(verificationCode);
    }

    @Override
    public VerificationCode getVerificationCodeById(Long id) throws Exception {
        Optional<VerificationCode> verificationCode = verificationCodeRepo.findById(id);
        if (verificationCode.isEmpty()) {
            throw new Exception("Verfication code not found");
        }
        return verificationCode.get();
    }

    @Override
    public VerificationCode getVerificationCodeByUserId(Long userId) throws Exception {
        return verificationCodeRepo.findByUserId(userId);
    }

    @Override
    public void deleteVerificationCode(VerificationCode verificationCode) throws Exception {
        verificationCodeRepo.delete(verificationCode);
    }

}
