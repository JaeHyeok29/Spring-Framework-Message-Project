package com.nhnacademy.edu.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final String MESSAGE = "test message";

    public static void main(String[] args) {
        User user = new User("email", "phoneNumber");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework");
        MessageSenderService messageSendService = context.getBean("messageSenderService", MessageSenderService.class);

        messageSendService.sendMessage(user, MESSAGE);
    }
}
