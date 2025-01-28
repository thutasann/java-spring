package com.thuta.trading_backend.service.payment_order;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.thuta.trading_backend.entity.PaymentOrder;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.PAYMENT_METHOD;
import com.thuta.trading_backend.enums.PAYMENT_ORDER_STATUS;
import com.thuta.trading_backend.repository.PaymentOrderRepository;
import com.thuta.trading_backend.response.PaymentResponse;

@Service
public class PaymentOrderService implements IPaymentOrderService {
    @Autowired
    private PaymentOrderRepository paymentOrderRepo;

    @Value("${stripe.api.key}")
    private String stripeSecretKey;

    @Value("${razorpay.api.key}")
    private String razorpayApiKey;

    @Value("${razorpay.api.secret}")
    private String razorpayApiSecret;

    @Override
    public PaymentOrder createOrder(User user, Long amount, PAYMENT_METHOD paymentMethod) {
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setUser(user);
        paymentOrder.setAmount(amount);
        paymentOrder.setPaymentMethod(paymentMethod);
        return paymentOrderRepo.save(paymentOrder);
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) throws Exception {
        return paymentOrderRepo.findById(id).orElseThrow(() -> new Exception("Payment order not found"));
    }

    @Override
    public Boolean proceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) throws RazorpayException {
        if(paymentOrder.getStatus().equals(PAYMENT_ORDER_STATUS.PENDING)) {
            if(paymentOrder.getPaymentMethod().equals(PAYMENT_METHOD.RAZORPAY)) {
                RazorpayClient razorpayClient = new RazorpayClient(razorpayApiKey, razorpayApiSecret);
                Payment payment = razorpayClient.payments.fetch(paymentId);

                @SuppressWarnings("unused")
                Integer amount = payment.get("amount");
                String status = payment.get("status");

                if(status.equals("captured")) {
                    paymentOrder.setStatus(PAYMENT_ORDER_STATUS.SUCCESS);
                    return true;
                }
                paymentOrder.setStatus(PAYMENT_ORDER_STATUS.FAILED);
                paymentOrderRepo.save(paymentOrder);
                return false;
            }
            
            paymentOrder.setStatus(PAYMENT_ORDER_STATUS.SUCCESS);
            paymentOrderRepo.save(paymentOrder);
            return true;
        }
        return false;
    }

    @Override
    public PaymentResponse createRazorPaymentLink(User user, Long amount) throws Exception {
        Long Amount = amount * 100;

        try {
            RazorpayClient razorpayClient = new RazorpayClient(razorpayApiKey, razorpayApiSecret);

            // Create a JSON object with the payment link request parameters
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", Amount);
            paymentLinkRequest.put("currency", "INR");

            // Create a JSON Object with the customer details
            JSONObject customerDetails = new JSONObject();
            customerDetails.put("name", user.getFullName());
            customerDetails.put("email", user.getEmail());
            paymentLinkRequest.put("customer", customerDetails);

            // Create a JSON Object with the notification settings
            JSONObject notificationSettings = new JSONObject();
            notificationSettings.put("email", true);
            notificationSettings.put("notify", true);
            paymentLinkRequest.put("notify", notificationSettings);
            paymentLinkRequest.put("reminder_enable", true);

            // Set the callback URL and method
            paymentLinkRequest.put("callback_url", "http://localhost:5173/wallet");
            paymentLinkRequest.put("callback_method", "get");

            // Create the payment link
            PaymentLink paymentLink = razorpayClient.paymentLink.create(paymentLinkRequest);

            String paymentLinkId = paymentLink.get("id");
            String paymentLinkUrl = paymentLink.get("short_url");

            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setPayment_url(paymentLinkUrl);
            paymentResponse.setPayment_id(paymentLinkId);
            return paymentResponse;
        } catch (Exception e) {
            System.out.println("Error Creating payment link: " + e.getMessage());
            throw new Exception("Failed to create Razorpay payment link " + e.getMessage());
        }
    }

    @Override
    public PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId) throws Exception {
        return null;
    }
}
