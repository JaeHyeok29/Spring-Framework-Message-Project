package com.nhnacademy.edu.springframework;

public class MessageSenderService {

    private MessageSender messageSender;

    public MessageSenderService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(User user, String message) {
        messageSender.sendMessage(user, message);
    }
}
