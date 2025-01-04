package com.thutasann.project_management_backend.service.user;

import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.request.LoginRequest;
import com.thutasann.project_management_backend.response.AuthResponse;

public interface IUserService {
    AuthResponse signup(User user);

    AuthResponse signin(LoginRequest loginRequest);
}
