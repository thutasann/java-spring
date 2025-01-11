package com.thutasann.project_management_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thutasann.project_management_backend.models.Message;

public interface MessagesRepository extends JpaRepository<Message, Long> {
    List<Message> findByChatIdOrderByCreatedAtAsc(Long chatId);
}
