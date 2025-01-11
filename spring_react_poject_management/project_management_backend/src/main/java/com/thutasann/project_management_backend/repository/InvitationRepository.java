package com.thutasann.project_management_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thutasann.project_management_backend.models.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    Invitation findByToken(String token);

    Invitation findByEmail(String userEmail);
}
