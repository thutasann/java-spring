package com.thutasann.shopping_cart.security.user;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thutasann.shopping_cart.model.User;
import com.thutasann.shopping_cart.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException("User not found (Shop User Details Service)"));
        return ShopUserDetails.buildUserDetails(user);
    }

}
