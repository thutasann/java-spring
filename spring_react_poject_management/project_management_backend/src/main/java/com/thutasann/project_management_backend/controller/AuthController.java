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
    public ResponseEntity<User> signup(@RequestBody User user) throws Exception {
        User savedUser = userService.signup(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) throws Exception {
        AuthResponse authResponse = userService.signin(loginRequest);
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

}
