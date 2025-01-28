package com.thuta.trading_backend.service.payment_order;

import com.razorpay.RazorpayException;
import com.thuta.trading_backend.entity.PaymentOrder;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.PAYMENT_METHOD;
import com.thuta.trading_backend.response.PaymentResponse;

public interface IPaymentOrderService {
    /**
     * Create a payment order
     * @param user - The user who is making the payment
     * @param amount - The amount to be paid
     * @param paymentMethod - The payment method to be used
     * @return - The payment order
     */
    PaymentOrder createOrder(
            User user,
            Long amount,
            PAYMENT_METHOD paymentMethod);

    /**
     * Get a payment order by its id
     * @param id - The id of the payment order
     * @return - The payment order
     */
    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    /**
     * Proceed with a payment order
     * @param paymentOrder - The payment order to be proceeded
     * @param paymentId - The payment id
     * @return - True if the payment is successful, false otherwise
     */
    Boolean proceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) throws RazorpayException;

    /**
     * Create a Razorpay payment link
     * @param user - The user who is making the payment
     * @param amount - The amount to be paid
     * @return - The payment response
     */
    PaymentResponse createRazorPaymentLink(User user, Long amount) throws Exception;

    /**
     * Create a Stripe payment link
     * @param user - The user who is making the payment
     * @param amount - The amount to be paid
     * @param orderId - The id of the order
     * @return - The payment response
     */
    PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId) throws Exception;
}
