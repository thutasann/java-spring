package com.thuta.trading_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thuta.trading_backend.entity.ForgotPasswordToken;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.VerificationCode;
import com.thuta.trading_backend.enums.VERIFICATION_TYPE;
import com.thuta.trading_backend.request.ForgotPasswordTokenRequest;
import com.thuta.trading_backend.request.ResetPasswordRequest;
import com.thuta.trading_backend.response.AuthResponse;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.EmailService;
import com.thuta.trading_backend.service.forgot_password.IForgotPasswordService;
import com.thuta.trading_backend.service.user.IUserService;
import com.thuta.trading_backend.service.verification_code.IVerificationCodeService;
import com.thuta.trading_backend.util.OtpUtils;

@RestController
@RequestMapping("${api.prefix}/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private IVerificationCodeService verificationCodeService;

    @Autowired
    private IForgotPasswordService forgotPasswordService;

    @GetMapping("/profile")
    public ResponseEntity<DataResponse> getUserProfile(
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            return ResponseEntity.ok(new DataResponse("user profile by jwt", user));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", null));
        }
    }

    @PostMapping("/verification/send-otp")
    public ResponseEntity<DataResponse> sendVerificationOtp(
            @RequestHeader("Authorization") String jwt,
            @RequestParam VERIFICATION_TYPE verificationType) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUserId(user.getId());

            if (verificationCode == null) {
                verificationCode = verificationCodeService.createVerificationCode(user, verificationType);
            }

            if (verificationType.equals(VERIFICATION_TYPE.EMAIL)) {
                emailService.sendEmail(user.getEmail(), verificationCode.getOtp());
            }

            return ResponseEntity.ok(new DataResponse("sent verification otp success", user));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", null));
        }
    }

    @PatchMapping("/enable-two-factor/verify-otp")
    public ResponseEntity<DataResponse> enableTwoFactorAuthentication(
            @RequestHeader("Authorization") String jwt,
            @RequestParam String otp) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUserId(user.getId());

            String sendTo = verificationCode.getVerificationType().equals(VERIFICATION_TYPE.EMAIL)
                    ? verificationCode.getEmail()
                    : verificationCode.getMobile();

            boolean isVerified = verificationCode.getOtp().equals(otp);

            if (isVerified) {
                User updatedUser = userService.enableTwoFactorAuthentication(verificationCode.getVerificationType(),
                        sendTo, user);

                verificationCodeService.deleteVerificationCode(verificationCode);

                return ResponseEntity.ok(new DataResponse("enable two factor otp success", updatedUser));
            }
            return ResponseEntity.status(NOT_FOUND)
                    .body(new DataResponse("OTP not matched", null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", null));
        }
    }

    /** testing purpose */
    @GetMapping("/forgot-password/tokens")
    public ResponseEntity<DataResponse> findAllOtps() {
        List<ForgotPasswordToken> tokens = forgotPasswordService.findAll();
        return ResponseEntity.ok(new DataResponse("tokens get success", tokens));
    }

    @PostMapping("/reset-password/send-otp")
    public ResponseEntity<DataResponse> resetPasswordSendOtp(
            @RequestBody ForgotPasswordTokenRequest request) {
        try {
            System.out.println("forgot password request email ==> " + request.getSendTo());
            User user = userService.findUserProfileByEmail(request.getSendTo());
            String otp = OtpUtils.generateOTP();

            ForgotPasswordToken token = forgotPasswordService.findByUserId(user.getId());

            if (token == null) {
                token = forgotPasswordService.createToken(user, otp, request.getVerificationType(),
                        request.getSendTo());
            }

            if (request.getVerificationType().equals(VERIFICATION_TYPE.EMAIL)) {
                emailService.sendEmail(user.getEmail(), token.getOtp());
            }

            AuthResponse authResponse = new AuthResponse();
            authResponse.setSession(token.getId().toString());
            authResponse.setMessage("Password rest otp sent successfully");

            return ResponseEntity.ok(new DataResponse("forgot password mail sent success", authResponse));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @PatchMapping("/reset-password/verify-otp")
    public ResponseEntity<DataResponse> resetPasswordVerifyOtp(
            @RequestParam String id,
            @RequestBody ResetPasswordRequest request) {
        try {
            ForgotPasswordToken forgotPasswordToken = forgotPasswordService.findById(id);

            boolean isVerified = forgotPasswordToken.getOtp().equals(request.getOtp());

            if (isVerified) {
                userService.updatePassword(forgotPasswordToken.getUser(), request.getPassword());
                return ResponseEntity.ok(new DataResponse("password reset success", null));
            }

            return ResponseEntity.status(NOT_FOUND)
                    .body(new DataResponse("OTP not matched", null));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", null));
        }
    }
}
