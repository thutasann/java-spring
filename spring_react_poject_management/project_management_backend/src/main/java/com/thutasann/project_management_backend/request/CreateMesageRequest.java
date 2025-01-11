package com.thutasann.project_management_backend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMesageRequest {
    private Long projectId;
    private String content;
}
