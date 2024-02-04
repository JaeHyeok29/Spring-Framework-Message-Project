package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@PropertySource("classpath:dooraymessage.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

    @Value(value = "${hookurl}")
    private String hookUrl;

    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(new RestTemplate(), hookUrl);
    }

    @Bean
    public DoorayMessageSender doorayMessageSender() {
        return new DoorayMessageSender(doorayHookSender(), hookUrl);
    }

    @Bean
    public MessageSenderService messageSenderService() {
        return new MessageSenderService(doorayMessageSender());
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
