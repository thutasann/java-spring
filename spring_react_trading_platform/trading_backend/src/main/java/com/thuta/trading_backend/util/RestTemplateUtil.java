package com.thuta.trading_backend.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestTemplateUtil {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Utility method to make REST API calls.
     *
     * @param url         The URL of the API endpoint.
     * @param method      The HTTP method to use (GET, POST, etc.).
     * @param requestBody The request body (can be null for GET requests).
     * @param headers     The headers for the request.
     * @param typeRef     The type reference for the response object.
     * @param <T>         The type of the response object.
     * @return The response object of the specified type.
     * @throws Exception if any error occurs during the API call or deserialization.
     */
    public static <T> T makeRequest(
            String url,
            HttpMethod method,
            Object requestBody,
            HttpHeaders headers,
            TypeReference<T> typeRef) throws Exception {
        HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, method, entity, String.class);

        return objectMapper.readValue(response.getBody(), typeRef);
    }
}
