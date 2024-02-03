package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayMessageSender implements MessageSender {

    private final DoorayHookSender doorayHookSender;
    private final String hookurl;

    public DoorayMessageSender(@Qualifier("doorayHookSender") DoorayHookSender doorayHookSender, @Value("${hookurl}") String hookurl) {
        this.doorayHookSender = doorayHookSender;
        this.hookurl = hookurl;
    }

    @Override
    public boolean sendMessage(User user, String message) {
        try {
            // DoorayHookSender 객체를 생성할 때 외부 속성인 hookurl을 사용하여 생성
            DoorayHookSender hookSender = new DoorayHookSender(new RestTemplate(), hookurl);

            // DoorayHookSender 객체를 사용하여 메시지 전송
            hookSender.send(DoorayHook.builder()
                    .botName(user.getFirstName() + user.getLastName())
                    .text(message)
                    .build());
            return true; // 전송 성공 시 true 반환
        } catch (Exception e) {
            // 예외 발생 시 false 반환
            return false;
        }
    }

}
