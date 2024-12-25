package com.thutasann.shopping_cart.service.cart;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.thutasann.shopping_cart.exceptions.ResourceNotFoundException;
import com.thutasann.shopping_cart.model.Cart;
import com.thutasann.shopping_cart.repository.CartItemRepository;
import com.thutasann.shopping_cart.repository.CartRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        return cart;
    }

    @Transactional
    @Override
    public void clearCart(Long id) {
        Cart cart = this.getCart(id);
        cartItemRepository.deleteAllByCartId(id);
        cart.getItems().clear();
        cartRepository.deleteById(id);
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = this.getCart(id);
        return cart.getTotalAmount();
    }

    @Override
    public Long initializeNewCart() {
        Cart newCart = new Cart();
        System.out.println("Initializing a new cart...");
        return cartRepository.save(newCart).getId();
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

}
