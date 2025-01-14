package com.thuta.trading_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}")
public class HomeController {
    @GetMapping
    public String home() {
        return "Welcome to Trading Platform API V1";
    }
}
