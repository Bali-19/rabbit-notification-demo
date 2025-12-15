package com.example.api_producer.service;

import com.example.api_producer.config.RabbitConfig;
import com.example.shared.NotificationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notify(String status, String message) {
        NotificationMessage notificationMessage = new NotificationMessage(status, message);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, notificationMessage);
    }
}
