package com.nhnacademy.edu.springframework;

import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@PropertySource(value = "classpath:greeter.properties", encoding = "UTF-8")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
