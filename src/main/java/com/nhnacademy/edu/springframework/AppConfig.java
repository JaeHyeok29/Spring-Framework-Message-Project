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

    @Bean
    public DoorayHookSender doorayHookSender() {
        String hookUrl = "https://hook.dooray.com/services/3204376758577275363/3727911831849652136/t0TgHWJ1S9SWgyLnHKk53Q";
        RestTemplate restTemplate = new RestTemplate();
        return new DoorayHookSender(restTemplate, hookUrl);
    }

}
