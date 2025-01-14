package com.thuta.trading_backend.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Response Object
 */
@Data
@AllArgsConstructor
public class DataResponse {
    private String message;
    private Object data;
}
