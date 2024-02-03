package com.nhnacademy.edu.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// 맨마지막이 main만들어라 다음 stop watch를 만들어라
public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSenderService messageSenderService = (MessageSenderService) context.getBean("messageSenderService");

            // 사용할 User 객체 생성
            User user = new User ("김","재혁");

            // MessageSenderService를 사용하여 메세지 보내기
            messageSenderService.sendMessage(user, "정신 나갈 것 같다.");


        }
    }
}

// Main 만들기전에 bean 만들어야 함 classPath를 만들어야해서


/*
 // DoorayHookSender 빈을 가져옴
            DoorayHookSender doorayHookSender = (DoorayHookSender) context.getBean("doorayHookSender");

            // DoorayMessageSender 빈을 가져옴
            DoorayMessageSender doorayMessageSender = (DoorayMessageSender) context.getBean("doorayMessageSender");

            // MessageSenderService 빈을 가져옴
            MessageSenderService messageSenderService = (MessageSenderService) context.getBean("messageSenderService");

            // 사용할 User 객체 생성
            User user = new User("John", "Doe");

            // MessageSenderService를 사용하여 메시지 보내기
            messageSenderService.sendMessage(user, "Hello, Spring!");

            // DoorayMessageSender를 사용하여 메시지 보내기
            doorayMessageSender.sendMessage(user, "Hello, Dooray!");

            // DoorayHookSender를 사용하여 메시지 보내기
            doorayHookSender.send(new DoorayHook());
 */