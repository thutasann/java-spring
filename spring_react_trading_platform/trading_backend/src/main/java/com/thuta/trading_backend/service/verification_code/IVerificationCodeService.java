package com.thuta.trading_backend.service.verification_code;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.VerificationCode;
import com.thuta.trading_backend.enums.VERIFICATION_TYPE;

public interface IVerificationCodeService {
    VerificationCode createVerificationCode(User user, VERIFICATION_TYPE verificationType) throws Exception;

    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode getVerificationCodeByUserId(Long userId) throws Exception;

    void deleteVerificationCode(VerificationCode verificationCode) throws Exception;
}
