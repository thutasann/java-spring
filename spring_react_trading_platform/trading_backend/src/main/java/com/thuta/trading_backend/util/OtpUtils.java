package com.thuta.trading_backend.util;

import java.util.Random;

public class OtpUtils {
    /**
     * Generate OTP Util Function
     * 
     * @return Random OTP String
     */
    public static String generateOTP() {
        int otpLength = 6;
        Random random = new Random();
        StringBuilder otp = new StringBuilder(otpLength);

        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }

        return otp.toString();
    }
}
