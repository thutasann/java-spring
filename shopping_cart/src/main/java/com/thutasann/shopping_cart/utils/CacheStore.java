package com.thutasann.shopping_cart.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CacheStore<K, V> {
    private final Map<K, CacheEntry<V>> cache = new ConcurrentHashMap<>();
    private final ScheduledExecutorService cleaner = Executors.newScheduledThreadPool(1);

    public CacheStore() {
        cleaner.scheduleAtFixedRate(this::cleanUp, 1, 1, TimeUnit.SECONDS);
    }

    public void put(K key, V value, long ttlMS) {
        long expiryTime = System.currentTimeMillis() + ttlMS;
        cache.put(key, new CacheEntry<>(value, expiryTime));
    }

    public V get(K key) {
        CacheEntry<V> entry = cache.get(key);
        if (entry == null || entry.isExpired()) {
            cache.remove(key);
            return null;
        }
        return entry.value;
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public void cleanUp() {
        long now = System.currentTimeMillis();
        cache.entrySet().removeIf(entry -> entry.getValue().isExpired(now));
    }

    private static class CacheEntry<V> {
        private final V value;
        private final long expiryTime;

        public CacheEntry(V value, long expiryTime) {
            this.value = value;
            this.expiryTime = expiryTime;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }

        boolean isExpired(long now) {
            return now > expiryTime;
        }
    }
}
