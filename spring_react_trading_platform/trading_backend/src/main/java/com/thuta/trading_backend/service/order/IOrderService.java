package com.thuta.trading_backend.service.order;

import java.util.List;

import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.entity.Order;
import com.thuta.trading_backend.entity.OrderItem;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.ORDER_TYPE;

public interface IOrderService {
    Order getOrderById(Long orderId) throws Exception;

    Order createOrder(User user, OrderItem orderItem, ORDER_TYPE orderType) throws Exception;

    List<Order> getAllOrdersOfUser(Long userId, ORDER_TYPE orderType, String assetSymbol) throws Exception;

    Order processOrder(Coin coin, double quantity, ORDER_TYPE orderType, User user) throws Exception;

    Order buyAsset(Coin coin, double quantity, User user) throws Exception;

    Order sellAsset(Coin coin, double quantity, User user) throws Exception;
}
