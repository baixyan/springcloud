package com.example.apigataway.config;

/**
 * created by baixuyan on 2018/6/19
 *
 * @author baixuyan
 **/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {


    @Bean
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}
