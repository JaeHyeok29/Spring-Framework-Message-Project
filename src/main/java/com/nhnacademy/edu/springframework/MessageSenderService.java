package com.nhnacademy.edu.springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MessageSenderService {

    private final MessageSender messageSender;

    public MessageSenderService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(User user, String message) {
        messageSender.sendMessage(user, message);
    }
}