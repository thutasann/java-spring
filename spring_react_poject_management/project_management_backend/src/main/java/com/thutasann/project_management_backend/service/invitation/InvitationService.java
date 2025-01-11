package com.thutasann.project_management_backend.service.invitation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thutasann.project_management_backend.models.Invitation;
import com.thutasann.project_management_backend.repository.InvitationRepository;
import com.thutasann.project_management_backend.service.email.IEmailService;

import jakarta.mail.MessagingException;

@Service
public class InvitationService implements IInvitationService {

    @Autowired
    private InvitationRepository invitationRepo;

    @Autowired
    private IEmailService emailService;

    @Override
    public void sendInvitation(String email, Long projectId) throws MessagingException {
        String invitationToken = UUID.randomUUID().toString();

        Invitation invitation = new Invitation();
        invitation.setEmail(email);
        invitation.setProjectId(projectId);
        invitation.setToken(invitationToken);
        invitationRepo.save(invitation);

        String invitationLink = "http://localhost:8080/api/projects/accept-invitation?token=" + invitationToken;

        emailService.sendEmailWithTokenLink(email, invitationLink);
    }

    @Override
    public Invitation acceptInvitation(String token, Long userId) throws Exception {
        Invitation invitation = invitationRepo.findByToken(token);
        if (invitation == null) {
            throw new Exception("Invalid Invitation Token");
        }
        return invitation;
    }

    @Override
    public String getTokenByUserMail(String userEmail) {
        Invitation invitation = invitationRepo.findByEmail(userEmail);
        return invitation.getEmail();
    }

    @Override
    public void deleteToken(String token) {
        Invitation invitation = invitationRepo.findByToken(token);
        invitationRepo.delete(invitation);
    }

}
