package com.thutasann.project_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.repository.UserRepository;
import com.thutasann.project_management_backend.service.CustomUserDetailsImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsImpl customUserDetails;

    @PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(@RequestBody User user) throws Exception {

        User isUserExit = userRepo.findByEmail(user.getEmail());

        if (isUserExit != null) {
            throw new Exception("Email already exit with another account");
        }

        User createdUser = new User();
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
        createdUser.setEmail(user.getEmail());
        createdUser.setFullName(user.getFullName());

        User savedUser = userRepo.save(createdUser);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
