package com.thuta.trading_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuta.trading_backend.entity.PaymentDetails;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.request.AddPaymentDetailsRequest;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.payment_details.IPaymentDetailsService;
import com.thuta.trading_backend.service.user.IUserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("${api.prefix}/payment-details")
public class PaymentDetailsController {
    @Autowired
    private IPaymentDetailsService paymentDetailsService;

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public ResponseEntity<DataResponse> getUserWatchList(
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            PaymentDetails paymentDetails = paymentDetailsService.getUserPaymentDetails(user);

            return ResponseEntity.ok(new DataResponse("get user payment details success", paymentDetails));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @PostMapping("/")
    public ResponseEntity<DataResponse> addPaymentDetails(
            @RequestHeader("Authorization") String jwt,
            @RequestBody AddPaymentDetailsRequest request) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            PaymentDetails paymentDetails = paymentDetailsService.addPaymentDetails(
                    request.getAccountNumber(),
                    request.getAccountHolderName(),
                    request.getIfsc(),
                    request.getBankName(),
                    user);

            return ResponseEntity.ok(new DataResponse("create user payment details success", paymentDetails));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }
}
