package com.thuta.trading_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.razorpay.RazorpayException;
import com.thuta.trading_backend.entity.PaymentOrder;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.PAYMENT_METHOD;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.response.PaymentResponse;
import com.thuta.trading_backend.service.payment_order.IPaymentOrderService;
import com.thuta.trading_backend.service.user.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    private IPaymentOrderService paymentOrderService;

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<DataResponse> createPaymentOrder(@RequestBody PaymentOrder paymentOrder, @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            PaymentResponse paymentResponse;

            PaymentOrder order = paymentOrderService.createOrder(user, paymentOrder.getAmount(), paymentOrder.getPaymentMethod());

            if(paymentOrder.getPaymentMethod().equals(PAYMENT_METHOD.RAZORPAY)) {
                paymentResponse = paymentOrderService.createRazorPaymentLink(user, order.getId());
            } else {
                paymentResponse = paymentOrderService.createStripePaymentLink(user, paymentOrder.getAmount(), order.getId());
            }

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new DataResponse("Payment order created successfully", paymentResponse));
        } 
        catch (RazorpayException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body(new DataResponse("An unexpected error occurred while creating Razorpay payment link", e.getMessage()));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }
}
