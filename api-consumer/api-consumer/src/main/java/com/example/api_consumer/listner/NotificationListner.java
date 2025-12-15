package com.example.api_consumer.listner;

import com.example.api_consumer.config.RabbitConfig;
import com.example.api_consumer.service.NotifyService;
import com.example.shared.NotificationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NotificationListner {

    @Autowired
    private NotifyService notifyService;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(NotificationMessage message) {
        System.out.println("Received: " + message.getMessage());
        notifyService.sendSms(message.getStatus() + ": " + message.getMessage());
    }

}
