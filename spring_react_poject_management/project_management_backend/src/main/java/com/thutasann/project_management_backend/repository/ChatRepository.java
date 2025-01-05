package com.thutasann.project_management_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thutasann.project_management_backend.models.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
