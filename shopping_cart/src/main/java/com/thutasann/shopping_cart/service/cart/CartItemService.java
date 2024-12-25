package com.thutasann.shopping_cart.service.cart;

import org.springframework.stereotype.Service;

import com.thutasann.shopping_cart.model.CartItem;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartItemService implements ICartItemService {
    @Override
    public void AddItemToCart(Long cartId, Long productId, int quantity) {
        throw new UnsupportedOperationException("Unimplemented method 'AddItemToCart'");
    }

    @Override
    public void removeItemFromCart(Long cartId, Long productId) {
        throw new UnsupportedOperationException("Unimplemented method 'removeItemFromCart'");
    }

    @Override
    public void updateItemQuantity(Long cartId, Long productId, int quantity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateItemQuantity'");
    }

    @Override
    public CartItem getCartItem(Long cartId, Long productId) {
        throw new UnsupportedOperationException("Unimplemented method 'getCartItem'");
    }

}
