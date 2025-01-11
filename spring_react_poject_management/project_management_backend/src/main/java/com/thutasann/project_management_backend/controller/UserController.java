package com.thutasann.project_management_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.response.DataResponse;
import com.thutasann.project_management_backend.service.user.IUserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "BearerAuth")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/profile")
    public ResponseEntity<DataResponse> getUserProfile(
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            return ResponseEntity.ok(new DataResponse("get user profile", user));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }
}
