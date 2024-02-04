package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@PropertySource(value = "classpath:dooraymessage.properties", encoding = "UTF-8")
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class AppConfig {
    @Bean
    public MessageService messageService() {
        return new EmailService();
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    @Bean
//    public DoorayHookSender doorayHookSender(RestTemplate restTemplate, @Value("${hookUrl}") String hookUrl) {
//        return new DoorayHookSender(restTemplate, hookUrl);
//    }
//
//    @Bean
//    public DoorayMessageSender doorayMessageSender(DoorayHookSender doorayHookSender) {
//        return new DoorayMessageSender(doorayHookSender);
//    }
}
