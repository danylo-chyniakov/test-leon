package com.parsing.leon.config;

import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Value("${feign.retryer.period}")
    private int retryerPeriod;

    @Value("${feign.retryer.maxPeriod}")
    private int retryerMaxPeriod;

    @Value("${feign.retryer.maxAttempts}")
    private int retryerMaxAttempts;


    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(retryerPeriod, retryerMaxPeriod, retryerMaxAttempts);
    }
}
