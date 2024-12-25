package com.thutasann.shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thutasann.shopping_cart.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllByCartId(Long cartId);
}
