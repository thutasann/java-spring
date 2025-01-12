package com.thutasann.project_management_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.thutasann.project_management_backend.utilities.redis.RedisSubscriber;

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

    /**
     * Channel Topic
     * 
     * @return
     */
    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("myTopic");
    }

    /**
     * Redis Message Listener Container
     * 
     * @param connectionFactory - connection factory
     * @param listenerAdapter   - listener adapter
     * @return RedisMessageListenerContainer
     */
    @Bean
    public RedisMessageListenerContainer redisContainer(
            RedisConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, topic());
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RedisSubscriber subscriber) {
        return new MessageListenerAdapter(subscriber, "onMessage");
    }
}
