package com.thutasann.project_management_backend.service.message;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thutasann.project_management_backend.models.Chat;
import com.thutasann.project_management_backend.models.Message;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.repository.MessagesRepository;
import com.thutasann.project_management_backend.repository.UserRepository;
import com.thutasann.project_management_backend.service.project.IProjectService;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessagesRepository messagesRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IProjectService projectService;

    @Override
    public Message sendMessage(Long senderId, Long projectId, String content) throws Exception {

        User sender = userRepository.findById(senderId).orElseThrow(() -> new Exception(
                "user not found with this send id: " + senderId));

        Chat chat = projectService.getProjectById(projectId).getChat();

        Message message = new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setCreatedAt(LocalDateTime.now());
        message.setChat(chat);
        Message savedMessage = messagesRepo.save(message);

        chat.getMessages().add(savedMessage);
        return savedMessage;
    }

    @Override
    public List<Message> getMessagesByProjectId(Long projectId) throws Exception {
        try {
            Chat chat = projectService.getChatByProjectId(projectId);

            List<Message> messages = messagesRepo.findByChatIdOrderByCreatedAtAsc(chat.getId());

            return messages;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
