package com.nhnacademy.edu.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final String MESSAGE = "test message";

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("AppConfig.class")) {
            MessageSenderService messageSenderService = context.getBean(MessageSenderService.class);

            User user = new User("email", "phoneNumber");
            messageSenderService.sendMessage(user, MESSAGE);
        }


    }
}
