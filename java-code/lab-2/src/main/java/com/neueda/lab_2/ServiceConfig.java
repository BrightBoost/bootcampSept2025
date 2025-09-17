package com.neueda.lab_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Value("${greeting.type:morning}")
    public String type;
    @Bean
    public GreetingService mornigGreetingService() {
        switch (type) {
            case "evening":
                return new EveningGreetingService();
            case "nonn":
                return new NoonGreetingService();
            case "morning":
            default:
                return new MorningGreetingService();

        }

    }
}
