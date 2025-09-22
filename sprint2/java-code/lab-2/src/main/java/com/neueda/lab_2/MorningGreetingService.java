package com.neueda.lab_2;

import org.springframework.stereotype.Component;

//@Component
public class MorningGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Good Morning";
    }
}
