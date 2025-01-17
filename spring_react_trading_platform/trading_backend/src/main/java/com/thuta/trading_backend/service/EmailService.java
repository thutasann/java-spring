package com.thuta.trading_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * Send Email Service
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Send Email With Toke Link
     * 
     * @param userEmail - Target User Email
     * @param otp       - OTP
     * @throws MessagingException
     */
    public void sendEmail(String userEmail, String otp) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        String subject = "Verify OTP";
        String text = "Yout OTP is : " + otp;

        helper.setSubject(subject);
        helper.setText(text, true);
        helper.setTo(userEmail);

        try {
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new MessagingException("Failed to send email");
        }
    }
}
