package com.thuta.trading_backend.service.order;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.Order;
import com.thuta.trading_backend.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

    private OrderRepository orderRepo;

    @Override
    public Order getOrderById(Long orderId) throws Exception {
        Optional<Order> order = orderRepo.findById(orderId);
        if (order.isEmpty()) {
            throw new Exception("Order not found with this Id " + orderId);
        }
        return order.get();
    }

}
