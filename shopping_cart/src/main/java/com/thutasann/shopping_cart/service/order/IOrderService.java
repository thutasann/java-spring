package com.thutasann.shopping_cart.service.order;

import java.util.List;

import com.thutasann.shopping_cart.dto.OrderDto;
import com.thutasann.shopping_cart.model.Order;

public interface IOrderService {
    Order placeOrder(Long userId);

    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);
}
