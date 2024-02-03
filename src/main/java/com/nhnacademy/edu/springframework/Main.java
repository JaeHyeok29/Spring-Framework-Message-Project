package com.nhnacademy.edu.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// 맨마지막이 main만들어라 다음 stop watch를 만들어라
public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSenderService messageSenderService = (MessageSenderService) context.getBean("messageSenderService");

            // 사용할 User 객체 생성
            User user = new User("김", "재혁");

            // MessageSenderService를 사용하여 메세지 보내기
            messageSenderService.sendMessage(user, "정신 나갈 것 같다.");


        }
    }
}