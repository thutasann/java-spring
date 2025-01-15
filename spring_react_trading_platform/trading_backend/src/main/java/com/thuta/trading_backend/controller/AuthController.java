package com.thuta.trading_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.beans.factory.annotation.Autowired;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.auth.IAuthService;

@RestController
@RequestMapping("${api.prefix}/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<DataResponse> register(@RequestBody User user) {
        try {
            String jwtToken = authService.register(user);
            return ResponseEntity.ok(new DataResponse("Signup successful", jwtToken));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(BAD_REQUEST).body(new DataResponse(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", null));
        }
    }
}
