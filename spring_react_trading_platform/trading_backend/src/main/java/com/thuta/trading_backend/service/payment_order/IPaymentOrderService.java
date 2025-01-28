package com.thuta.trading_backend.service.payment_order;

import com.thuta.trading_backend.entity.PaymentOrder;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.PAYMENT_METHOD;
import com.thuta.trading_backend.response.PaymentResponse;

public interface IPaymentOrderService {
    PaymentOrder createOrder(
            User user,
            Long amount,
            PAYMENT_METHOD paymentMethod);

    PaymentOrder getPaymentOrderById(Long id);

    Boolean proceedPaymentOrder(PaymentOrder paymentOrder, String paymentId);

    PaymentResponse createRazorPaymentLink(User user, Long amount);

    PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId);
}
