package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.web.client.RestTemplate;

public class DoorayMessageSender implements MessageSender {

    private final DoorayHookSender doorayHookSender;
    private final String hookurl;

//    @Autowired
//    public DoorayMessageSender(@Qualifier("doorayHookSender") DoorayHookSender doorayHookSender, @Value("${hookurl}") String hookurl) {
//        this.doorayHookSender = doorayHookSender;
//        this.hookurl = hookurl;
//    }

    public DoorayMessageSender(DoorayHookSender doorayHookSender, String hookurl) {
        this.doorayHookSender = doorayHookSender;
        this.hookurl = hookurl;
    }

    @Override
    public boolean sendMessage(User user, String message) {
        try {

            DoorayHookSender hookSender = new DoorayHookSender(new RestTemplate(), hookurl);

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
