package com.thutasann.project_management_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    /**
     * Redis Template
     * 
     * @param connectionFactory - Redis Connection Factory
     * @return Redis Template
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // Connection Factory
        template.setConnectionFactory(connectionFactory);

        // Key serializer
        template.setKeySerializer(new StringRedisSerializer());

        // Value serializer
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }
}
