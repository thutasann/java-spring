package com.thutasann.project_management_backend.utilities.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RedisSubscriber {

    private static final Logger logger = LoggerFactory.getLogger(RedisSubscriber.class);

    public void onMessage(String message, String channel) {
        logger.info("Received message '{}' from channel '{}'", message, channel);
    }
}