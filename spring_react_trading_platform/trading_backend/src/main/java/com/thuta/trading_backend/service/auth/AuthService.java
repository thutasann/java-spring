package com.thuta.trading_backend.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.repository.UserRepository;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) throws Exception {
        try {
            User newUser = new User();
            newUser.setFullName(user.getFullName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));

            User savedUser = userRepo.save(newUser);
            return savedUser;
        } catch (Exception e) {
            throw new Exception("Something went wrong at signup");
        }
    }
}
