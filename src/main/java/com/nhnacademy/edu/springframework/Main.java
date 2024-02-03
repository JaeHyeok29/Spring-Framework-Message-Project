package com.nhnacademy.edu.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSenderService messageSenderService = (MessageSenderService) context.getBean("messageSenderService");

            User user = new User("김", "재혁");

            messageSenderService.sendMessage(user, "정신 나갈 것 같다.");


        }
    }
}