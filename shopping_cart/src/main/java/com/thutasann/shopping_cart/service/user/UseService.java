package com.thutasann.shopping_cart.service.user;

import org.springframework.stereotype.Service;

import com.thutasann.shopping_cart.dto.UserDto;
import com.thutasann.shopping_cart.model.User;
import com.thutasann.shopping_cart.request.CreateUserRequest;
import com.thutasann.shopping_cart.request.UserUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UseService implements IUserService {
    @Override
    public User getUserById(Long userId) {
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public User createUser(CreateUserRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public User updateUser(UserUpdateRequest request, Long userId) {
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(Long userId) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public UserDto convertUserToDto(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'convertUserToDto'");
    }

}
