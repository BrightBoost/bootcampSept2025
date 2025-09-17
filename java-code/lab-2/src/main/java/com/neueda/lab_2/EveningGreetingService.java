package com.neueda.lab_2;

//@Component
public class EveningGreetingService implements GreetingService{
    @Override
    public String greet() {
        return "Good Evening";
    }
}
