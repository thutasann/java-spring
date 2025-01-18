package com.thuta.trading_backend.service.user;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.VERIFICATION_TYPE;

public interface IUserService {
    public User findUserProfileByJwt(String jwt) throws Exception;

    public User findUserProfileByEmail(String email) throws Exception;

    public User findUserById(Long userId) throws Exception;

    public User enableTwoFactorAuthentication(VERIFICATION_TYPE verificationType, String sentTo, User user)
            throws Exception;

    public User updatePassword(User user, String newPassword) throws Exception;
}
