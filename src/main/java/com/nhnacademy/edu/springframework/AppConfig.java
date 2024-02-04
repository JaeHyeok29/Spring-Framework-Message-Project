package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@PropertySource("classpath:dooraymessage.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

    @Bean
    public DoorayHookSender doorayHookSender() {
        String uri = "https://hook.dooray.com/services/3204376758577275363/3727553265487230503/DIiyr9z0ROKJksd5yMFedQ";
        RestTemplate restTemplate = new RestTemplate();
        return new DoorayHookSender(restTemplate, uri);
    }


//    @Value(value = "${hookurl}")
//    private String hookUrl;
//
//    @Bean
//    public DoorayHookSender doorayHookSender() {
//        return new DoorayHookSender(new RestTemplate(), hookUrl);
//    }
//
//    @Bean
//    public DoorayMessageSender doorayMessageSender() {
//        return new DoorayMessageSender(doorayHookSender(), hookUrl);
//    }
//
//    @Bean
//    public MessageSenderService messageSenderService() {
//        return new MessageSenderService(doorayMessageSender());
//    }
//
//    @Bean
//    public LoggingAspect loggingAspect() {
//        return new LoggingAspect();
//    }
}
