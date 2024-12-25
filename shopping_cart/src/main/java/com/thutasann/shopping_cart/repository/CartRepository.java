package com.thutasann.shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thutasann.shopping_cart.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}
