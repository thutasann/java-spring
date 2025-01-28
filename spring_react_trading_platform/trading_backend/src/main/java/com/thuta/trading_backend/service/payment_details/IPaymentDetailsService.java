package com.thuta.trading_backend.service.payment_details;

import com.thuta.trading_backend.entity.PaymentDetails;
import com.thuta.trading_backend.entity.User;

public interface IPaymentDetailsService {
    PaymentDetails addPaymentDetails(
            String accountNumber,
            String accountHoldername,
            String ifsc,
            String bankName,
            User user);

    PaymentDetails getUserPaymentDetails(User user);
}
