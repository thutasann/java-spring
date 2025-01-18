package com.thuta.trading_backend.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.TwoFactorAuth;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.VERIFICATION_TYPE;
import com.thuta.trading_backend.repository.UserRepository;
import com.thuta.trading_backend.util.JwtProvider;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findUserProfileByJwt(String jwt) throws Exception {
        String email = JwtProvider.getEmailFromToken(jwt);
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }
        return user;
    }

    @Override
    public User findUserProfileByEmail(String email) throws Exception {
        Optional<User> user = Optional.ofNullable(userRepo.findByEmail(email));
        if (user.isEmpty()) {
            throw new Exception("User not found with this email " + email);
        }
        return user.get();
    }

    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> user = userRepo.findById(userId);
        if (user.isEmpty()) {
            throw new Exception("User not found");
        }
        return user.get();
    }

    @Override
    public User enableTwoFactorAuthentication(VERIFICATION_TYPE verificationType, String sentTo, User user) {
        TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
        twoFactorAuth.setEnabled(true);
        twoFactorAuth.setSendTo(verificationType);

        user.setTwoFactorAuth(twoFactorAuth);
        return userRepo.save(user);
    }

    @Override
    public User updatePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        return userRepo.save(user);
    }
}
