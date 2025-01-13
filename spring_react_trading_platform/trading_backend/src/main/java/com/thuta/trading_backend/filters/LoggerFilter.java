package com.thuta.trading_backend.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        long startTime = System.currentTimeMillis();

        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;

        // ANSI color codes
        String resetColor = "\u001B[0m";
        String methodColor = "\u001B[32m"; // Green
        String uriColor = "\u001B[34m"; // Blue
        String statusColor = httpResponse.getStatus() >= 400 ? "\u001B[31m" : "\u001B[32m"; // Red for errors, Green
        String timeColor = duration > 500 ? "\u001B[33m" : "\u001B[32m"; // Yellow for slow responses, Green otherwise

        System.out.println(methodColor + "Request: " + httpRequest.getMethod() + resetColor +
                " " + uriColor + httpRequest.getRequestURI() + resetColor +
                " | " + statusColor + "Response Status: " + httpResponse.getStatus() + resetColor +
                " | " + timeColor + "Time Taken: " + duration + " ms" + resetColor);
    }
}
