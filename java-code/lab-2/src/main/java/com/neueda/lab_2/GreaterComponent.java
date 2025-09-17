package com.neueda.lab_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GreaterComponent {
    private final Logger logger = LoggerFactory.getLogger(GreaterComponent.class);
    private GreetingService greetingService;

    public GreaterComponent(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    public  String hello(){
        return greetingService.greet();
    }
}
