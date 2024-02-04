package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayMessageSender implements MessageSender {

    private final DoorayHookSender doorayHookSender;
    private final String hookUrl;

    public DoorayMessageSender(DoorayHookSender doorayHookSender, String hookUrl) {
        this.doorayHookSender = doorayHookSender;
        this.hookUrl = hookUrl;
    }

    @Override
    @MeasureExecutionTime
    public boolean sendMessage(User user, String message) {
        try {

            DoorayHookSender hookSender = new DoorayHookSender(new RestTemplate(), hookUrl);

            hookSender.send(DoorayHook.builder()
                    .botName(user.getFirstName() + user.getLastName())
                    .text(message)
                    .build());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
