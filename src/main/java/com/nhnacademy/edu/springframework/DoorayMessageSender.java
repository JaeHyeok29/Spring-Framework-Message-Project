package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Component
@Aspect
public class DoorayMessageSender implements MessageSender {

    private final DoorayHookSender doorayHookSender;
    private final String hookurl;

    public DoorayMessageSender(DoorayHookSender doorayHookSender, String hookurl) {
        this.doorayHookSender = doorayHookSender;
        this.hookurl = hookurl;
    }

    @Override
    @Around("execution(* com.nhnacademy.edu.springframework.DoorayMessageSender.sendMessage(..))")
    public boolean sendMessage(User user, String message) {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            DoorayHookSender hookSender = new DoorayHookSender(new RestTemplate(), hookurl);

            hookSender.send(DoorayHook.builder()
                    .botName(user.getFirstName() + user.getLastName())
                    .text(message)
                    .build());

            stopWatch.stop();
            long executionTime = stopWatch.getTotalTimeMillis();
            System.out.println("DoorayMessageSender.sendMessage " + executionTime + "ms");

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
