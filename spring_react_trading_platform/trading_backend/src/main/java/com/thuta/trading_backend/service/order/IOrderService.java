package com.thuta.trading_backend.service.order;

import com.thuta.trading_backend.entity.Order;

public interface IOrderService {
    Order getOrderById(Long orderId) throws Exception;
}
