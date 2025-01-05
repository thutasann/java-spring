package com.thutasann.project_management_backend.service.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thutasann.project_management_backend.models.Chat;
import com.thutasann.project_management_backend.repository.ChatRepository;

@Service
public class ChatService implements IChatService {

    @Autowired
    private ChatRepository chatRepo;

    @Override
    public Chat createChat(Chat chat) {
        return chatRepo.save(chat);
    }

}
