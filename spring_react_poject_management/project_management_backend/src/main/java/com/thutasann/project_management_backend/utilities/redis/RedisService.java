package com.thutasann.project_management_backend.utilities.redis;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Redis Service
 */
@Service
public class RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final ObjectMapper objectMapper;

    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    /**
     * Cache data with a specific key and TTL.
     *
     * @param key  The Redis key
     * @param data The data to cache
     * @param ttl  The time-to-live in seconds
     */
    public void cacheData(String key, Object data, long ttl) {
        try {
            String jsonData = objectMapper.writeValueAsString(data);
            redisTemplate.opsForValue().set(key, jsonData, Duration.ofSeconds(ttl));
            logger.info("Data cached with key: {}", key);
        } catch (JsonProcessingException e) {
            logger.error("Error serializing data for caching with key: {}", key, e);
        }
    }

    /**
     * Retrieve cached data by key.
     *
     * @param key The Redis key
     * @return The cached object or null if not found or deserialization fails
     */
    public <T> T getCachedData(String key, Class<T> type) {
        try {
            String jsonData = (String) redisTemplate.opsForValue().get(key);
            if (jsonData != null) {
                logger.info("Cache hit for key: {}", key);
                return objectMapper.readValue(jsonData, type); // Type-safe deserialization
            }
        } catch (JsonProcessingException e) {
            logger.error("Error deserializing cached data for key: {}", key, e);
        }
        return null;
    }

    /**
     * Evict a specific cache by key.
     *
     * @param key The Redis key
     */
    public void evictCache(String key) {
        redisTemplate.delete(key);
        logger.info("Cache evicted for key: {}", key);
    }

    /**
     * Delete Cached Data
     * 
     * @param key - Key
     */
    public void deleteCachedData(String key) {
        redisTemplate.delete(key);
    }

    /**
     * Increment Key
     * 
     * @param key   - Key
     * @param delta - Delta
     * @return Increment key
     */
    public Long incrementKey(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * Set with Conditional Check
     * 
     * @param key              - Key
     * @param value            - Value
     * @param timeoutInSeconds - timeoutSeconds
     * @return Boolean Value
     */
    @SuppressWarnings("null")
    public boolean setIfAbsent(String key, Object value, long timeoutInSeconds) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, Duration.ofSeconds(timeoutInSeconds));
    }
}
