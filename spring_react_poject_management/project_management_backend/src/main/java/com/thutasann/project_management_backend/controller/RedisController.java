package com.thutasann.project_management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.utilities.redis.RedisPublisher;

/**
 * Redis Testing Purpose
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisPublisher redisPublisher;

    @GetMapping("/publish")
    public String publishMessage(@RequestParam String message) {
        redisPublisher.publish(message);
        return "Message published: " + message;
    }
}
