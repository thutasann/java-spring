package com.thutasann.project_management_backend.service.email;

import jakarta.mail.MessagingException;

public interface IEmailService {
    /**
     * Send Email with token link
     * 
     * @param userEmail - user Email
     * @param link      - link
     * @throws Exception - throw exception
     */
    void sendEmailWithTokenLink(String userEmail, String link) throws MessagingException;
}
