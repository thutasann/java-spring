package com.thutasann.project_management_backend.service.message;

import java.util.List;

import com.thutasann.project_management_backend.models.Message;

public interface IMessageService {
    Message sendMessage(Long senderId, Long projectId, String content) throws Exception;

    List<Message> getMessagesByProjectId(Long projectId) throws Exception;
}
