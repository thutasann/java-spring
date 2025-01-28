package com.thuta.trading_backend.service.payment_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.PaymentOrder;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.PAYMENT_METHOD;
import com.thuta.trading_backend.repository.PaymentOrderRepository;
import com.thuta.trading_backend.response.PaymentResponse;

@Service
public class PaymentOrderService implements IPaymentOrderService {
    @Autowired
    private PaymentOrderRepository paymentOrderRepo;

    @Override
    public PaymentOrder createOrder(User user, Long amount, PAYMENT_METHOD paymentMethod) {
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentOrderById'");
    }

    @Override
    public Boolean proceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) {
        throw new UnsupportedOperationException("Unimplemented method 'proceedPaymentOrder'");
    }

    @Override
    public PaymentResponse createRazorPaymentLink(User user, Long amount) {
        throw new UnsupportedOperationException("Unimplemented method 'createRazorPaymentLink'");
    }

    @Override
    public PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId) {
        throw new UnsupportedOperationException("Unimplemented method 'createStripePaymentLink'");
    }
}
