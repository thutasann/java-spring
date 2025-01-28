package com.thuta.trading_backend.service.payment_details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.PaymentDetails;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.repository.PaymentDetailsRepository;

@Service
public class PaymentDetailsService implements IPaymentDetailsService {
    @Autowired
    private PaymentDetailsRepository paymentDetailsRepo;

    @Override
    public PaymentDetails addPaymentDetails(String accountNumber, String accountHoldername, String ifsc,
            String bankName, User user) {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAccountNumber(accountNumber);
        paymentDetails.setAccountHolderName(accountHoldername);
        paymentDetails.setIfsc(ifsc);
        paymentDetails.setBankName(bankName);
        paymentDetails.setUser(user);
        return paymentDetailsRepo.save(paymentDetails);
    }

    @Override
    public PaymentDetails getUserPaymentDetails(User user) {
        return paymentDetailsRepo.findByUserId(user.getId());
    }
}
