package com.example.api_consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE = "notification.queue";
    public static final String EXCHANGE = "notification.exchange";
    public static final String ROUTING_KEY = "notification.key";

    @Bean
    public Queue queue() { return new Queue(QUEUE, true); }

    @Bean
    public DirectExchange exchange() { return new DirectExchange(EXCHANGE); }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
