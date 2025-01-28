package com.thuta.trading_backend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentDetailsRequest {
    private String accountNumber;

    private String accountHolderName;

    private String ifsc;

    private String bankName;
}
