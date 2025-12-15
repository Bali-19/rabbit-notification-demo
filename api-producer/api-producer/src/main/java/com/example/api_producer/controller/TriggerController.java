package com.example.api_producer.controller;

import com.example.api_producer.service.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TriggerController {

    @Autowired
    private MessagePublisher publisher;

    @GetMapping("/")
    public String home() {
        return "Producer API is running. Use /trigger to send notification.";
    }

    @GetMapping("/trigger")
    public String trigger() {
        publisher.notify("SUCCESS", "Baraa just made his first notification via RabbitMQ");
        return "Notified";
    }
}
