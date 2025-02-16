package com.thuta.spring_security_exercise.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(HttpServletRequest request) {
        return "Welcome to Spring Security " + request.getSession().getId();
    }
}
