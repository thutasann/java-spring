package com.thutasann.shopping_cart.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private String response;
    private Object data;
}
