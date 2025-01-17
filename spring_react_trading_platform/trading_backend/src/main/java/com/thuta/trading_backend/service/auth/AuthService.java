package com.thuta.trading_backend.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.TwoFactorOTP;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.repository.UserRepository;
import com.thuta.trading_backend.request.LoginRequest;
import com.thuta.trading_backend.response.AuthResponse;
import com.thuta.trading_backend.service.CustomUserDetailsService;
import com.thuta.trading_backend.service.EmailService;
import com.thuta.trading_backend.service.two_factor_otp.ITwoFactorOtpService;
import com.thuta.trading_backend.util.JwtProvider;
import com.thuta.trading_backend.util.OtpUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetails;

    @Autowired
    private ITwoFactorOtpService twoFactorOtpService;

    @Autowired
    private EmailService emailService;

    @PersistenceContext
    private EntityManager entityManager;

    public void refreshEntity(Object entity) {
        entityManager.refresh(entity);
    }

    public void deleteEntity(Object entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

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
    @Transactional
    public AuthResponse signIn(LoginRequest request) throws Exception {
        if (request == null) {
            throw new IllegalArgumentException("Login Request cannot be null");
        }

        String username = request.getEmail();
        String password = request.getPassword();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = JwtProvider.generateToken(authentication);

        User user = userRepo.findByEmail(request.getEmail());

        if (request.getTwoFactorAuth().isEnabled()) {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setMessage("Two factor auth is enabled");
            authResponse.setTwoFactorAuthEnabled(true);

            String otp = OtpUtils.generateOTP();

            TwoFactorOTP oldTwoFactorOTP = twoFactorOtpService.findByUser(user.getId());
            if (oldTwoFactorOTP != null) {
                twoFactorOtpService.deleteTwoFactorOtp(oldTwoFactorOTP);
                return authResponse;
            }

            TwoFactorOTP newTwoFactorOTP = twoFactorOtpService.createTwoFactorOtp(user, otp, jwt);

            emailService.sendEmail(request.getEmail(), otp);

            authResponse.setSession(newTwoFactorOTP.getId().toString());
            return authResponse;
        }

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
            System.out.println("invalid password =>>>");
            throw new BadCredentialsException("Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null);
    }

}
