package com.thutasann.project_management_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.models.Message;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.request.CreateMesageRequest;
import com.thutasann.project_management_backend.response.DataResponse;
import com.thutasann.project_management_backend.service.message.IMessageService;
import com.thutasann.project_management_backend.service.user.IUserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/messages")
@SecurityRequirement(name = "BearerAuth")
public class MessagesController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;

    @PostMapping("/send")
    public ResponseEntity<DataResponse> sendMessage(
            @RequestBody CreateMesageRequest request,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            User tokenUser = userService.findUserProfileByJwt(jwt);
            Message message = messageService.sendMessage(tokenUser.getId(), request.getProjectId(),
                    request.getContent());
            return ResponseEntity.ok(new DataResponse("message created", message));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get/{projectId}")
    public ResponseEntity<DataResponse> getMessagesByProjectId(
            @PathVariable Long projectId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            List<Message> messages = messageService.getMessagesByProjectId(projectId);
            return ResponseEntity.ok(new DataResponse("get messages by project Id", messages));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }
}
