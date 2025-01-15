package com.thuta.trading_backend.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.repository.UserRepository;
import com.thuta.trading_backend.request.LoginRequest;
import com.thuta.trading_backend.response.AuthResponse;
import com.thuta.trading_backend.service.CustomUserDetailsService;
import com.thuta.trading_backend.util.JwtProvider;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetails;

    @Override
    public AuthResponse register(User user) throws Exception {
        User isEmailExist = userRepo.findByEmail(user.getEmail());
        if (isEmailExist != null) {
            throw new IllegalArgumentException("User already exists with this email: " + user.getEmail());
        }

        User newUser = new User();
        newUser.setFullName(user.getFullName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        // authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // save user
        userRepo.save(newUser);

        // generate token
        String jwt = JwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setStatus(true);

        return authResponse;
    }

    @Override
    public AuthResponse signIn(LoginRequest request) throws Exception {
        if (request == null) {
            throw new IllegalArgumentException("Login Request cannot be null");
        }

        String username = request.getEmail();
        String password = request.getPassword();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = JwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setStatus(true);

        return authResponse;
    }

    /**
     * Authenticate user
     * 
     * @return
     */
    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customUserDetails.loadUserByUsername(username);
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null);
    }

}
