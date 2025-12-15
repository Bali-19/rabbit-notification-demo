package com.example.api_consumer.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {

    // Replace with your Twilio Account SID and Auth Token

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.fromNumber}")
    private String fromNumber;

    private static final String TO_NUMBER = "your number";

    public NotifyService() {
        Twilio.init(accountSid, authToken);
    }

    public void sendSms(String messageText) {
        Message.creator(
                new PhoneNumber(TO_NUMBER),
                new PhoneNumber(fromNumber),
                messageText
        ).create();
    }
}
