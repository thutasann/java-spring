package com.thutasann.shopping_cart.service.cart;

import com.thutasann.shopping_cart.model.CartItem;

public interface ICartItemService {
    /**
     * Add Item cart
     * 
     * @param cartId
     * @param productId
     * @param quantity
     */
    void AddItemToCart(Long cartId, Long productId, int quantity);

    /**
     * Remove Item From cart
     * 
     * @param cartId
     * @param productId
     */
    void removeItemFromCart(Long cartId, Long productId);

    /**
     * Update Cart Item Quantity
     * 
     * @param cartId
     * @param productId
     * @param quantity
     */
    void updateItemQuantity(Long cartId, Long productId, int quantity);

    /**
     * Get cart Item by Cart Id and ProductId
     * 
     * @param cartId
     * @param productId
     * @return
     */
    CartItem getCartItem(Long cartId, Long productId);
}
