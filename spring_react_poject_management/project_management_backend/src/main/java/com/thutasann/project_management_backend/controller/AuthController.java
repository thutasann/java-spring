package com.thutasann.project_management_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.request.LoginRequest;
import com.thutasann.project_management_backend.response.AuthResponse;
import com.thutasann.project_management_backend.service.user.IUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody User user) throws Exception {
        AuthResponse response = userService.signup(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) throws Exception {
        AuthResponse authResponse = userService.signin(loginRequest);
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

}
