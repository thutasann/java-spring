package com.thutasann.project_management_backend.service.invitation;

import com.thutasann.project_management_backend.models.Invitation;

import jakarta.mail.MessagingException;

public interface IInvitationService {
    /**
     * send invitation
     * 
     * @param email
     * @param projectId
     */
    void sendInvitation(String email, Long projectId) throws MessagingException;

    /**
     * Accept Invitation
     * 
     * @param token
     * @param userId
     * @return
     */
    Invitation acceptInvitation(String token, Long userId) throws Exception;

    /**
     * Get token by User Email
     * 
     * @param userEmail
     * @return
     */
    String getTokenByUserMail(String userEmail);

    /**
     * Delete Token
     * 
     * @param token
     */
    void deleteToken(String token);
}
