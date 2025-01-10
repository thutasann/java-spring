package com.thutasann.project_management_backend.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataResponse {
    private String response;
    private Object data;
}
